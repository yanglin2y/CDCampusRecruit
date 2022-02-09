package com.ycode.cdcr.hrcloud.controller;

import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.hrcloud.service.HrRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangLin
 * @createTime 2022/02/09
 */
@RestController
@RequestMapping("relation")
public class HrRelationController {
  @Autowired
  HrRelationService hrRelationService;

  @GetMapping("selectRelation")
  public Result selectRelation(){
    return  hrRelationService.selectRelation();
  }

  @PostMapping("addRelation")
  public Result addRelation(String uid, String apName, String apImg){
    return hrRelationService.addRelation(uid, apName, apImg);
  }
}
