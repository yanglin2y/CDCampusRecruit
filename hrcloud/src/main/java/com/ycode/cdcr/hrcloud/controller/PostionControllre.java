package com.ycode.cdcr.hrcloud.controller;

import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.hrcloud.service.RecruitmentPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangLin
 * @createTime 2022/02/07
 */
@RestController
@RequestMapping("postion")
public class PostionControllre {

  @Autowired
  RecruitmentPositionService recruitmentPositionService;


  @PostMapping("postJob")
 public Result postJob(String eid, String rpName, String education, String salary, String workAddress,
      String experience,String jobResponsibilities){
   return recruitmentPositionService.postJob(eid, rpName, education, salary, workAddress, experience, jobResponsibilities);
 }
  @GetMapping("selectRPByEid")
  public Result selectRPByEid(String eid){
    return recruitmentPositionService.selectRPByEid(eid);
  }
  @PostMapping("delPostion")
  public Result delPostion(Integer rpid){
    return recruitmentPositionService.delPostion(rpid);
  }

}
