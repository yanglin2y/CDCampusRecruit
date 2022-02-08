package com.ycode.cdcr.hrcloud.service;


import com.ycode.cdcr.base.vo.LoginHrVo;
import com.ycode.cdcr.hrcloud.entity.po.Token;

public interface TokenService {

    Token save(LoginHrVo loginHrVo);

    LoginHrVo getLoginUser(String jwtToken);

    boolean deleteToken(String token);

}
