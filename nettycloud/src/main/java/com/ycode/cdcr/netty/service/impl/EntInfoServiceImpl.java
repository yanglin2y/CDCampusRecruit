package com.ycode.cdcr.netty.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycode.cdcr.base.entity.EntInfo;
import com.ycode.cdcr.base.mapper.EntInfoMapper;
import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.netty.service.EntInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YangLin
 * @createTime 2022/01/21
 */
@Service
public class EntInfoServiceImpl extends ServiceImpl<EntInfoMapper, EntInfo> implements
    EntInfoService {

  @Autowired
  EntInfoService entInfoService;
  @Override
  public Result selectEnt(Page<EntInfo> page) {
    return Result.success(entInfoService.page(page));
  }
}
