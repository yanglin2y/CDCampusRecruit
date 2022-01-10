package com.ycode.cdcr.applicantcloud.service;


import com.ycode.cdcr.applicantcloud.entity.po.Token;
import com.ycode.cdcr.base.vo.LoginApUserVo;

public interface TokenService {

    Token save(LoginApUserVo loginUser);

    LoginApUserVo getLoginUser(String jwtToken);

    boolean deleteToken(String token);

}
