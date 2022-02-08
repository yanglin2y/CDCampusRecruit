package com.ycode.cdcr.hrcloud.controller;

import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.hrcloud.service.HrResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangLin
 * @createTime 2022/02/07
 */
@RestController
@RequestMapping("resume")
public class HrResumeController {

  @Autowired
  HrResumeService hrResumeService;

  @GetMapping("selectHrResume")
  public Result selectHrResume(Integer rpid){
    return hrResumeService.selectHrResume(rpid);
  }
  @GetMapping("selectHrResumeByHrid")
  public Result selectHrResumeByHrid(){
    return hrResumeService.selectHrResumeByHrid();
  }

}
