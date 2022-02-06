package com.ycode.cdcr.entcloud.service.impl;


import com.alibaba.fastjson.JSON;
import com.ycode.cdcr.base.vo.LoginEntVo;
import com.ycode.cdcr.common.redis.MyRedisOperate;
import com.ycode.cdcr.common.util.FastJsonUtil;
import com.ycode.cdcr.entcloud.entity.po.Token;
import com.ycode.cdcr.entcloud.service.TokenService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class TokenServiceImpl implements TokenService {

  private static final Logger logger = LogManager.getLogger(TokenServiceImpl.class);

  /**
   * token过期秒数
   */
  @Value("${token.expire.seconds}")
  private Integer expireSeconds;
  /**
   * 私钥
   */
  @Value("${token.jwtSecret}")
  private String jwtSecret;

  private static final String LOGIN_USER_KEY = "LOGIN_SXENT_ENT_USER_KEY";
  private static Key KEY = null;
  private static final String REDIS_KEY_PRO = "Ent_TOKEN:token-";

  @Autowired
  private MyRedisOperate myRedisOperate;


  @Override
  public Token save(LoginEntVo loginEntVo) {

    String uuid = UUID.randomUUID().toString();
    String jwtToken = createJWTToken(uuid);

    //登入信息存redis
    myRedisOperate.set(REDIS_KEY_PRO + uuid, JSON.toJSONString(loginEntVo), expireSeconds);

    return new Token(jwtToken, System.currentTimeMillis());
  }

  @Override
  public LoginEntVo getLoginUser(String jwtToken) {
    String uuid = getUUIDFromJWT(jwtToken);
    if (uuid != null) {
      String Sign = REDIS_KEY_PRO + uuid;
      if (myRedisOperate.keyExists(Sign)) {
        LoginEntVo loginEnt = FastJsonUtil.toBeanFromStr(myRedisOperate.get(Sign),
            LoginEntVo.class);
        return loginEnt;
      } else {
        return null;
      }
    }
    return null;
  }

  /**
   * 生成jwt
   *
   * @return
   */
    private String createJWTToken(String uuid) {
    Map<String, Object> claims = new HashMap<>();
    // 放入一个随机字符串，通过该串可找到登陆用户
    claims.put(LOGIN_USER_KEY, uuid);

    String jwtToken = Jwts.builder().setClaims(claims)
        .signWith(SignatureAlgorithm.HS256, getKeyInstance())
        .compact();

    return jwtToken;
  }

  private Key getKeyInstance() {
    if (KEY == null) {
      synchronized (TokenServiceImpl.class) {
        if (KEY == null) {// 双重锁
          byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(jwtSecret);
          KEY = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());
        }
      }
    }

    return KEY;
  }


  private String getUUIDFromJWT(String jwt) {
    if ("null".equals(jwt) || StringUtils.isEmpty(jwt)) {
      return null;
    }

    Map<String, Object> jwtClaims = null;
    try {
      jwtClaims = Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(jwt).getBody();
      if (jwtClaims.containsKey(LOGIN_USER_KEY)) {
        return (String) jwtClaims.get(LOGIN_USER_KEY);
      }
      return null;
    } catch (ExpiredJwtException e) {
      logger.error("{}已过期", jwt);
    } catch (Exception e) {
      logger.error("{}", e);
    }

    return null;
  }

  /**
   * 数据库删除token
   *
   * @param jwtToken
   * @return
   */
  @Override
  public boolean deleteToken(String jwtToken) {
    //jwt解密
    String uuid = getUUIDFromJWT(jwtToken);

    if (uuid != null) {
      myRedisOperate.delKey(REDIS_KEY_PRO + uuid);
    }
    return false;
  }

}
