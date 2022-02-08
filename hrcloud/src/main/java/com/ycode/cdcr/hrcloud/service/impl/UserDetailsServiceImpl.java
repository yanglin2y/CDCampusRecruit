package com.ycode.cdcr.hrcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ycode.cdcr.base.entity.EntHr;
import com.ycode.cdcr.base.vo.LoginHrVo;
import com.ycode.cdcr.hrcloud.service.EntHrService;
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
  private EntHrService entHrService;

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    if (StringUtils.isEmpty(s)){
      throw new RuntimeException("请输入用户名");
    }
    EntHr account = entHrService.getOne(new QueryWrapper<EntHr>().eq("account", s));
    if (null == account){
      throw new RuntimeException("该HR没注册");
    }
    LoginHrVo loginHrVo = new LoginHrVo();
    BeanUtils.copyProperties(account, loginHrVo);
    return loginHrVo;
  }
}
