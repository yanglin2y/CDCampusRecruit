package com.ycode.cdcr.hrcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ycode.cdcr.base.entity.HrResume;
import com.ycode.cdcr.common.web.entity.vo.Result;

public interface HrResumeService extends IService<HrResume> {
  Result selectHrResume(Integer rpid);
  Result selectHrResumeByHrid();

}
