package com.ycode.cdcr.applicantcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ycode.cdcr.base.entity.EntInfo;
import com.ycode.cdcr.common.web.entity.vo.Result;

public interface EntInfoService extends IService<EntInfo> {
  Result selectEntInfoByEid(String eid);


}
