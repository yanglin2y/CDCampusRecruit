package com.ycode.cdcr.applicantcloud.util;

import com.ycode.cdcr.base.vo.LoginApUserVo;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author YangLin
 * @createTime 2022/01/19
 */
public class UserUtil {
  public static LoginApUserVo getLoginUser(){
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication!=null){
      if (authentication instanceof AnonymousAuthenticationToken){
        return null;
      }
      if (authentication instanceof UsernamePasswordAuthenticationToken){
        return (LoginApUserVo) authentication.getPrincipal();
      }
    }
    return null;
  }

}
