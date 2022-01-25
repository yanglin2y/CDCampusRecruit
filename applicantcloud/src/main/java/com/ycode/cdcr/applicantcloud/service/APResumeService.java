package com.ycode.cdcr.applicantcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ycode.cdcr.base.entity.APResume;
import com.ycode.cdcr.common.web.entity.vo.Result;

public interface APResumeService extends IService<APResume> {

  Result selectAPResumeByUid(Integer state);

  Result selectAllAPResume();

  Result jugResume(Integer rpid);

  Result addResume(String eid, String hrid, String rpid, String rpName, String workAddress,
      String education, String salary, String entName, String experience, String entImg,
      Integer state);
}
