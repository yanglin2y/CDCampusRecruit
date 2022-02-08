package com.ycode.cdcr.hrcloud.service;

import com.ycode.cdcr.common.web.entity.vo.Result;

public interface MyInfoService {
  //查询教育接口
  Result selectEducationInfoList(String uid);


  Result selectWorkInfoList(String uid);

  Result selectProjectInfoList(String uid);
}
