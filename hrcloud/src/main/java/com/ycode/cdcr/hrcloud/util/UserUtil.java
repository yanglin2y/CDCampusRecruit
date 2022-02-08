package com.ycode.cdcr.hrcloud.util;

import com.ycode.cdcr.base.vo.LoginHrVo;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author YangLin
 * @createTime 2022/01/19
 */
public class UserUtil {
  public static LoginHrVo getLoginUser(){
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication!=null){
      if (authentication instanceof AnonymousAuthenticationToken){
        return null;
      }
      if (authentication instanceof UsernamePasswordAuthenticationToken){
        return (LoginHrVo) authentication.getPrincipal();
      }
    }
    return null;
  }

}
