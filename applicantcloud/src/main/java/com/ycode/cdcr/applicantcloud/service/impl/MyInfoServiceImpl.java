package com.ycode.cdcr.applicantcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ycode.cdcr.applicantcloud.service.EducationInfoService;
import com.ycode.cdcr.applicantcloud.service.MyInfoService;
import com.ycode.cdcr.applicantcloud.service.ProjectInfoService;
import com.ycode.cdcr.applicantcloud.service.WorkInfoService;
import com.ycode.cdcr.applicantcloud.util.UserUtil;
import com.ycode.cdcr.base.entity.EducationInfo;
import com.ycode.cdcr.base.entity.ProjectInfo;
import com.ycode.cdcr.base.entity.WorkInfo;
import com.ycode.cdcr.common.web.entity.vo.Result;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
  public Result selectEducationInfoList() {
    String uid = UserUtil.getLoginUser().getUid();
    List<EducationInfo> edList = educationInfoService.list(
        new QueryWrapper<EducationInfo>().eq("uid", uid));
    return Result.success(edList);
  }

  /**
   * 添加教育信息
   *
   * @param
   * @return
   */
  @Override
  public Result addEducationInfo(Integer education, String school, String major, String startTime,
      String endTime) {
    String uid = UserUtil.getLoginUser().getUid();
    List<EducationInfo> uid1 = educationInfoService.list(
        new QueryWrapper<EducationInfo>().eq("uid", uid));
    if (uid1.size() < 4) {
      LocalDate newStartTime = LocalDate.parse(startTime,
          DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      LocalDate newEndTime = LocalDate.parse(endTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      EducationInfo educationInfo = EducationInfo.builder().education(education).school(school)
          .major(major).startTime(newStartTime).endTime(newEndTime).createTime(LocalDateTime.now())
          .uid(uid).build();
      boolean res = educationInfoService.save(educationInfo);
      return res == true ? Result.success("保存成功") : Result.fail("保存失败");
    } else {
      return Result.fail("您的教育经历已满,无法添加");
    }
  }

  @Override
  public Result updataEducationInfo(Integer id, Integer education, String school, String major,
      String startTime, String endTime) {
    String uid = UserUtil.getLoginUser().getUid();
    LocalDate newStartTime = LocalDate.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    LocalDate newEndTime = LocalDate.parse(endTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    EducationInfo educationInfo = EducationInfo.builder().education(education).school(school)
        .major(major).startTime(newStartTime).endTime(newEndTime).createTime(LocalDateTime.now())
        .uid(uid).id(id).build();
    boolean res = educationInfoService.update(educationInfo,
        new QueryWrapper<EducationInfo>().eq("id", id));
    return res == true ? Result.success("保存成功") : Result.fail("保存失败");
  }


  /**
   * 查询工作经历
   *
   * @param
   * @return
   */
  @Override
  public Result selectWorkInfoList() {
    String uid = UserUtil.getLoginUser().getUid();
    List<WorkInfo> workList = workInfoService.list(new QueryWrapper<WorkInfo>().eq("uid", uid));
    return Result.success(workList);
  }

  //添加工作经历
  @Override
  public Result addWorkInfo(String entName, String entIndustry, String occupation,
      String department, String content, String startTime, String endTime) {
    String uid = UserUtil.getLoginUser().getUid();
    List<WorkInfo> uid1 = workInfoService.list(new QueryWrapper<WorkInfo>().eq("uid", uid));
    if (uid1.size() < 10) {
      LocalDate newStartTime = LocalDate.parse(startTime,
          DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      LocalDate newEndTime = LocalDate.parse(endTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      WorkInfo workInfo = WorkInfo.builder().entName(entName).entIndustry(entIndustry)
          .occupation(occupation).department(department).content(content).startTime(newStartTime)
          .endTime(newEndTime).createTime(LocalDateTime.now()).uid(uid).build();
      boolean res = workInfoService.save(workInfo);
      return res == true ? Result.success("保存成功") : Result.fail("保存失败");
    } else {
      return Result.fail("您的工作经历已满,无法添加");
    }
  }

  //更新工作经历
  @Override
  public Result updataWorkInfo(Integer id, String entName, String entIndustry, String occupation,
      String department, String content, String startTime, String endTime) {
    String uid = UserUtil.getLoginUser().getUid();
    LocalDate newStartTime = LocalDate.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    LocalDate newEndTime = LocalDate.parse(endTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    WorkInfo workInfo = WorkInfo.builder().entName(entName).entIndustry(entIndustry)
        .occupation(occupation).department(department).content(content).startTime(newStartTime)
        .endTime(newEndTime).createTime(LocalDateTime.now()).build();
    boolean res = workInfoService.update(workInfo,
        new QueryWrapper<WorkInfo>().eq("uid", uid).eq("id", id));

    return res == true ? Result.success("保存成功") : Result.fail("保存失败");
  }

  @Override
  public Result selectProjectInfoList() {
    String uid = UserUtil.getLoginUser().getUid();
    List<ProjectInfo> projectList = projectInfoService.list(
        new QueryWrapper<ProjectInfo>().eq("uid", uid));
    return Result.success(projectList);
  }


  @Override
  public Result updataProjectInfo(Integer id, String projectName, String content, String startTime,
      String endTime) {
    String uid = UserUtil.getLoginUser().getUid();
    LocalDate newStartTime = LocalDate.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    LocalDate newEndTime = LocalDate.parse(endTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    ProjectInfo projectInfo = ProjectInfo.builder().projectName(projectName).content(content)
        .startTime(newStartTime).endTime(newEndTime).createTime(LocalDateTime.now()).build();
    boolean res = projectInfoService.update(projectInfo,
        new QueryWrapper<ProjectInfo>().eq("uid", uid).eq("id", id));

    return res == true ? Result.success("保存成功") : Result.fail("保存失败");

  }

  @Override
  public Result addProjectInfo(String projectName, String content, String startTime,
      String endTime) {
    String uid = UserUtil.getLoginUser().getUid();
    List<ProjectInfo> uid1 = projectInfoService.list(
        new QueryWrapper<ProjectInfo>().eq("uid", uid));
    if (uid1.size() < 4) {
      LocalDate newStartTime = LocalDate.parse(startTime,
          DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      LocalDate newEndTime = LocalDate.parse(endTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      ProjectInfo projectInfo = ProjectInfo.builder().projectName(projectName)
          .startTime(newStartTime).endTime(newEndTime).createTime(LocalDateTime.now()).uid(uid)
          .content(content).build();
      boolean res = projectInfoService.save(projectInfo);
      return res == true ? Result.success("保存成功") : Result.fail("保存失败");
    } else {
      return Result.fail("您的项目经历已满,无法添加");
    }
  }


}
