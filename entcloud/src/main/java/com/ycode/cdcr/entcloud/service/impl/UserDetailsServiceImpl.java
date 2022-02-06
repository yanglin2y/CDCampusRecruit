package com.ycode.cdcr.entcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ycode.cdcr.base.entity.EntInfo;
import com.ycode.cdcr.base.vo.LoginEntVo;
import com.ycode.cdcr.entcloud.service.EntInfoService;
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
  private EntInfoService entInfoService;

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    if (StringUtils.isEmpty(s)){
      throw new RuntimeException("请输入用户名");
    }
    EntInfo account = entInfoService.getOne(new QueryWrapper<EntInfo>().eq("account", s));
    if (null == account){
      throw new RuntimeException("该企业没注册");
    }
    LoginEntVo loginEntVo = new LoginEntVo();
    BeanUtils.copyProperties(account, loginEntVo);
    return loginEntVo;
  }
}
