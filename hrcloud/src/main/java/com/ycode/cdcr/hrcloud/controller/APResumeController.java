package com.ycode.cdcr.hrcloud.controller;

import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.hrcloud.service.APResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangLin
 * @createTime 2022/02/07
 */
@RestController
@RequestMapping("apresume")
public class APResumeController {

  @Autowired
  APResumeService apResumeService;

  @RequestMapping("watch")
  public Result updataApResume(String uid,String rpid){
    return apResumeService.updataApResume(uid,rpid);
  }
  @RequestMapping("passApResume")
  public Result passApResume(String uid,String rpid){
    return apResumeService.passApResume(uid,rpid);
  }
  @RequestMapping("delApResume")
  public Result delApResume(String uid,String rpid){
    return apResumeService.delApResume(uid,rpid);
  }
}
