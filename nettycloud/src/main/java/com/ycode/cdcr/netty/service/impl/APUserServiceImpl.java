package com.ycode.cdcr.netty.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycode.cdcr.base.entity.APUser;
import com.ycode.cdcr.base.mapper.APUserMapper;
import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.netty.service.APUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YangLin
 * @createTime 2022/01/10
 */
@Service
public class APUserServiceImpl extends ServiceImpl<APUserMapper, APUser> implements
    APUserService {

  @Autowired
  APUserService apUserService;

  @Override
  public Result selectAPUser(Page<APUser> page) {
    return Result.success(apUserService.page(page));
  }
}
