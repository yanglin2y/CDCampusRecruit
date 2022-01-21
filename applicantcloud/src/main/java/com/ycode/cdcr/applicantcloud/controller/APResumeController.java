package com.ycode.cdcr.applicantcloud.controller;

import com.ycode.cdcr.applicantcloud.service.APResumeService;
import com.ycode.cdcr.common.web.entity.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangLin
 * @createTime 2022/01/21
 */
@RestController
@RequestMapping("resume")
public class APResumeController {

  @Autowired
  APResumeService apResumeService;

  @GetMapping("selectAPResumeByUid")
  public Result selectAPResumeByUid(Integer state){
    return apResumeService.selectAPResumeByUid(state);
  }

}