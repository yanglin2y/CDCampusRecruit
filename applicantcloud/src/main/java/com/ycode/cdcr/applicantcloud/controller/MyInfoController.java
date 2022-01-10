package com.ycode.cdcr.applicantcloud.controller;

import com.ycode.cdcr.applicantcloud.service.MyInfoService;
import com.ycode.cdcr.common.web.entity.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangLin
 * @createTime 2022/01/10
 */
@RestController
@CrossOrigin
@RequestMapping("myinfo")
public class MyInfoController {

  @Autowired
  MyInfoService myInfoService;

  @GetMapping("selectEducationInfoList")
  public Result selectEducationInfoList() {
    return myInfoService.selectEducationInfoList();
  }

  @PostMapping("addEducationInfo")
  public Result addEducationInfo(Integer education, String school,
      String major, String startTime, String endTime) {
    return myInfoService.addEducationInfo(education, school, major, startTime, endTime);
  }

  @PostMapping("updataEducationInfo")
  public Result updataEducationInfo(Integer id, Integer education, String school,
      String major, String startTime, String endTime) {
    return myInfoService.updataEducationInfo(id, education, school, major, startTime, endTime);
  }

  @GetMapping("selectWorkInfoList")
  public Result selectWorkInfoList() {
    return myInfoService.selectWorkInfoList();
  }

  @PostMapping("addWorkInfo")
  public Result addWorkInfo(String entName, String entIndustry,
      String occupation, String department, String content, String startTime, String endTime) {
    return myInfoService.addWorkInfo(entName, entIndustry, occupation, department, content,
        startTime, endTime);
  }

  @PostMapping("updataWorkInfo")
  Result updataWorkInfo(Integer id, String entName, String entIndustry,
      String occupation, String department, String content, String startTime, String endTime) {
    return myInfoService.updataWorkInfo(id, entName, entIndustry, occupation, department, content,
        startTime, endTime);
  }
  @GetMapping("selectProjectInfoList")
  Result selectProjectInfoList(){
    return myInfoService.selectProjectInfoList();
  }
  @PostMapping("updataProjectInfo")
  Result updataProjectInfo(Integer id,String projectName,
      String content, String startTime, String endTime){
    return myInfoService.updataProjectInfo(id, projectName, content, startTime, endTime);
  }
  @PostMapping("addProjectInfo")
  Result addProjectInfo(String projectName,
       String content, String startTime, String endTime){
    return  myInfoService.addProjectInfo(projectName, content, startTime, endTime);
  }


}
