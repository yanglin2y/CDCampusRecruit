package com.ycode.cdcr.hrcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycode.cdcr.base.entity.APUser;
import com.ycode.cdcr.base.mapper.APUserMapper;
import com.ycode.cdcr.base.vo.UserInfoVo;
import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.hrcloud.service.APUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YangLin
 * @createTime 2022/01/10
 */
@Service
public class APUserServiceImpl extends ServiceImpl<APUserMapper, APUser> implements APUserService {

  @Autowired
  APUserService apUserService;


  @Override
  public Result userInfo(String uid) {
    APUser apUserServiceOne = apUserService.getOne(
        new QueryWrapper<APUser>().eq("uid", uid));
    UserInfoVo userInfoVo = new UserInfoVo();
    BeanUtils.copyProperties(apUserServiceOne,userInfoVo);
    return Result.success(userInfoVo);
  }



}
