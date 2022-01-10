package com.ycode.cdcr.applicantcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ycode.cdcr.applicantcloud.service.APUserService;
import com.ycode.cdcr.base.entity.APUser;
import com.ycode.cdcr.base.vo.LoginApUserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author YangLin
 * @createTime 2022/01/11
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private APUserService apUserService;

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    if (StringUtils.isEmpty(s)){
      throw new RuntimeException("请输入用户名");
    }
    APUser account = apUserService.getOne(new QueryWrapper<APUser>().eq("account", s));
    if (null == account){
      throw new RuntimeException("该用户没注册");
    }
    LoginApUserVo loginApUserVo = new LoginApUserVo();
    BeanUtils.copyProperties(account, loginApUserVo);
    return loginApUserVo;
  }
}
