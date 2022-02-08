package com.ycode.cdcr.hrcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ycode.cdcr.base.entity.RecruitmentPosition;
import com.ycode.cdcr.common.web.entity.vo.Result;

/**
 * @author YangLin
 * @createTime 2022/01/18
 */
public interface RecruitmentPositionService extends IService<RecruitmentPosition> {


  Result postJob(String eid, String rpName, String education, String salary, String workAddress,
      String experience,String jobResponsibilities);
  Result selectRPByEid(String eid);
  Result delPostion(Integer rpid);


}
