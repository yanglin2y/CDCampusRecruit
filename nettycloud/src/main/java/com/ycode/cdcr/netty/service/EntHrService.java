package com.ycode.cdcr.netty.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ycode.cdcr.base.entity.EntHr;
import com.ycode.cdcr.common.web.entity.vo.Result;

public interface EntHrService extends IService<EntHr> {
  Result selectHr(Page<EntHr> page);
}
