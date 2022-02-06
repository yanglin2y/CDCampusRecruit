package com.ycode.cdcr.entcloud.service;


import com.ycode.cdcr.base.vo.LoginEntVo;
import com.ycode.cdcr.entcloud.entity.po.Token;

public interface TokenService {

    Token save(LoginEntVo loginEntVo);

    LoginEntVo getLoginUser(String jwtToken);

    boolean deleteToken(String token);

}
