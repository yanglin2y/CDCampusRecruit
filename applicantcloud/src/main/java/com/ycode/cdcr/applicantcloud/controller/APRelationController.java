package com.ycode.cdcr.applicantcloud.controller;

import com.ycode.cdcr.applicantcloud.service.ApRelationService;
import com.ycode.cdcr.common.web.entity.vo.Result;
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
public class APRelationController {
  @Autowired
  ApRelationService apRelationService;

  @GetMapping("selectRelation")
  public Result selectRelation(){
    return  apRelationService.selectRelation();
  }

  @PostMapping("addRelation")
  public Result addRelation(String hrid, String hrName, String hrImg){
    return apRelationService.addRelation(hrid, hrName, hrImg);
  }
}
