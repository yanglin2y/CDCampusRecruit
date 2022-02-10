package com.ycode.cdcr.netty.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ycode.cdcr.base.entity.EntInfo;
import com.ycode.cdcr.common.web.entity.vo.Result;

public interface EntInfoService extends IService<EntInfo> {
  Result selectEnt(Page<EntInfo> page);
}
