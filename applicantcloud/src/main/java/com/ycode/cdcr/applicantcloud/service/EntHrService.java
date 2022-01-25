package com.ycode.cdcr.applicantcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ycode.cdcr.base.entity.EntHr;
import com.ycode.cdcr.common.web.entity.vo.Result;

public interface EntHrService extends IService<EntHr> {
  Result selectHrInfoByHrId(String hrId);

}
