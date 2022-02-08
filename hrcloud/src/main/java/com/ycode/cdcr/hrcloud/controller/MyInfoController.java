package com.ycode.cdcr.hrcloud.controller;

import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.hrcloud.service.MyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
  public Result selectEducationInfoList(String uid) {
    return myInfoService.selectEducationInfoList(uid);
  }



  @GetMapping("selectWorkInfoList")
  public Result selectWorkInfoList(String uid) {
    return myInfoService.selectWorkInfoList(uid);
  }


  @GetMapping("selectProjectInfoList")
  Result selectProjectInfoList(String uid){
    return myInfoService.selectProjectInfoList(uid);
  }


}
