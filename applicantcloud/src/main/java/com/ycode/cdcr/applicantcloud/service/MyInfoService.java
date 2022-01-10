package com.ycode.cdcr.applicantcloud.service;

import com.ycode.cdcr.common.web.entity.vo.Result;

public interface MyInfoService {
  //查询教育接口
  Result selectEducationInfoList();
  //添加教育信息接口
  Result addEducationInfo(Integer education, String school,
      String major, String startTime, String endTime);
  //更新教育信息接口
  Result updataEducationInfo(Integer id,Integer education, String school,
      String major, String startTime, String endTime);

  Result selectWorkInfoList();
  Result addWorkInfo(String entName, String entIndustry,
      String occupation, String department, String content, String startTime, String endTime);
  Result updataWorkInfo(Integer id,String entName, String entIndustry,
      String occupation, String department, String content, String startTime, String endTime);



  Result selectProjectInfoList();
  Result updataProjectInfo(Integer id, String projectName,
      String content, String startTime, String endTime);

  Result addProjectInfo(String projectName,
      String content, String startTime, String endTime);
}
