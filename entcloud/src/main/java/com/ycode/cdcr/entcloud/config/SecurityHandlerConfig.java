package com.ycode.cdcr.entcloud.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ycode.cdcr.base.entity.EntInfo;
import com.ycode.cdcr.base.vo.LoginEntVo;
import com.ycode.cdcr.common.util.ResponseUtil;
import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.entcloud.entity.po.Token;
import com.ycode.cdcr.entcloud.filter.TokenFilter;
import com.ycode.cdcr.entcloud.service.EntInfoService;
import com.ycode.cdcr.entcloud.service.TokenService;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.util.StringUtils;

/**
 * @author YangLin
 * @createTime 2022/01/11
 */
@Configuration
public class SecurityHandlerConfig {
  @Autowired
  EntInfoService entInfoService;
  @Autowired
  TokenService tokenService;
  public static final String TOKEN_KEY = "entToekn";

  @Bean
  public AuthenticationEntryPoint authenticationEntryPoint() {
    return (httpServletRequest, httpServletResponse, e) -> {
      String url = httpServletRequest.getRequestURI();
      if (url.endsWith(".html")){
        httpServletResponse.sendRedirect("/");
      }else{
        Map map = new HashMap<>();
        map.put("code", HttpStatus.UNAUTHORIZED.value()+"");
        map.put("messageText","请先登陆");
        ResponseUtil.responseJson(httpServletResponse,HttpStatus.UNAUTHORIZED.value(), map);
      }

    };
  }
  @Bean
  public AuthenticationFailureHandler loginFailureHandler() {
    return (request, response, exception) -> {
      String msg;
      if (exception instanceof BadCredentialsException) {
        msg = "密码错误";
      } else {
        msg = exception.getMessage();
      }
      Map<String, Object> data = new HashMap<>();
      data.put("loginMsg", msg);
      ResponseUtil.responseJson(response, HttpStatus.OK.value(), Result.fail(msg));
    };
  }
  @Bean
  public LogoutSuccessHandler logoutSuccessHandler(){
    return ((request, response, authentication) -> {
      String token = TokenFilter.getToken(request);
      Map map = new HashMap();
      map.put("code",Result.SUCCESS_CODE);
      map.put("mesg","退出成功");
      tokenService.deleteToken(token);
      ResponseUtil.responseJson(response,HttpStatus.OK.value(),map);
    });
  }
  @Bean
  public AuthenticationSuccessHandler loginSuccessHandler() {
    return (request, response, authentication) -> {
      String gettoken = getToken(request);
      if (gettoken!=null){
        tokenService.deleteToken(gettoken);
      }
      LoginEntVo loginEntVo = (LoginEntVo) authentication.getPrincipal() ;
      EntInfo entInfo = entInfoService.getOne(
          new QueryWrapper<EntInfo>().eq("eid", loginEntVo.getEid()));
      loginEntVo.setEid(entInfo.getEid());
      Token token = tokenService.save(loginEntVo);

      ResponseUtil.responseJson(response, HttpStatus.OK.value(), Result.success(token));

    };
  }
  public static String getToken(HttpServletRequest request) {
    String token = request.getParameter(TOKEN_KEY);
    if (StringUtils.isEmpty(token)) {
      token = request.getHeader(TOKEN_KEY);
    }
    if (StringUtils.isEmpty(token)) {
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
        for (Cookie cookie : cookies) {
          if (TOKEN_KEY.equals(cookie.getName())) {
            token = cookie.getValue();
            break;
          }
        }
      }
    }
    return token;

  }


}
