package com.ycode.cdcr.netty.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycode.cdcr.base.entity.EntHr;
import com.ycode.cdcr.base.mapper.EntHrMapper;
import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.netty.service.EntHrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YangLin
 * @createTime 2022/01/21
 */
@Service
public class EntHrServiceImpl extends ServiceImpl<EntHrMapper, EntHr> implements EntHrService {

  @Autowired
  EntHrService entHrService;


  @Override
  public Result selectHr(Page<EntHr> page) {
    return Result.success(entHrService.page(page));
  }
}
