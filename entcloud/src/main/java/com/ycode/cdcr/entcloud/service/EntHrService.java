package com.ycode.cdcr.entcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ycode.cdcr.base.entity.EntHr;
import com.ycode.cdcr.common.web.entity.vo.Result;

public interface EntHrService extends IService<EntHr> {
  Result selectHrInfoByHrId(String hrId);
  Result selectHrInfoByEid();
  Result selectHrInfoByEidList();
  Result agreeHr(String hrid);
  Result rejectHr(String hrid);
  Result delHr(String hrid);
}
