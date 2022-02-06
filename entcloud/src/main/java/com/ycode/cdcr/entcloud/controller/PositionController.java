package com.ycode.cdcr.entcloud.controller;

import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.entcloud.service.RecruitmentPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangLin
 * @createTime 2022/01/18
 */
@RestController
@RequestMapping("position")
public class PositionController {
  @Autowired
  RecruitmentPositionService recruitmentPositionService;


  @GetMapping("selectPostionByEnt")
  public Result selectPostionByEnt(String eid){
    return recruitmentPositionService.selectPostionByEnt(eid);
  }
  @PostMapping("delPostion")
  public Result delPostion(Integer rpid){
    return recruitmentPositionService.delPostion(rpid);
  }

}
