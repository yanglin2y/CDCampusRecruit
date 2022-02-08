package com.ycode.cdcr.hrcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ycode.cdcr.base.entity.EducationInfo;
import com.ycode.cdcr.base.entity.ProjectInfo;
import com.ycode.cdcr.base.entity.WorkInfo;
import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.hrcloud.service.EducationInfoService;
import com.ycode.cdcr.hrcloud.service.MyInfoService;
import com.ycode.cdcr.hrcloud.service.ProjectInfoService;
import com.ycode.cdcr.hrcloud.service.WorkInfoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YangLin
 * @createTime 2022/01/10
 */
@Service
public class MyInfoServiceImpl implements MyInfoService {

  @Autowired
  EducationInfoService educationInfoService;
  @Autowired
  WorkInfoService workInfoService;
  @Autowired
  ProjectInfoService projectInfoService;

  /**
   * 查询应聘者的教育信息
   *
   * @param
   * @return
   */
  @Override
  public Result selectEducationInfoList(String uid) {
    List<EducationInfo> edList = educationInfoService.list(
        new QueryWrapper<EducationInfo>().eq("uid", uid));
    return Result.success(edList);
  }



  /**
   * 查询工作经历
   *
   * @param
   * @return
   */
  @Override
  public Result selectWorkInfoList(String uid) {
    List<WorkInfo> workList = workInfoService.list(new QueryWrapper<WorkInfo>().eq("uid", uid));
    return Result.success(workList);
  }

  @Override
  public Result selectProjectInfoList(String uid) {
    List<ProjectInfo> projectList = projectInfoService.list(
        new QueryWrapper<ProjectInfo>().eq("uid", uid));
    return Result.success(projectList);
  }



}
