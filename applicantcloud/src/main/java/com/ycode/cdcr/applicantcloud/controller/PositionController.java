package com.ycode.cdcr.applicantcloud.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ycode.cdcr.applicantcloud.service.RecruitmentPositionService;
import com.ycode.cdcr.base.entity.RecruitmentPosition;
import com.ycode.cdcr.common.web.entity.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

  @GetMapping("selectAllPosition")
  public Result selectAllPosition(){

    return recruitmentPositionService.selectAllPosition();
  }
  @GetMapping("selectAllPositionByPage")
  public Result selectAllPositionByPage(Page<RecruitmentPosition> page){

    return recruitmentPositionService.selectAllPositionByPage(page);
  }
  @GetMapping("selectPostionById")
  public Result selectPostionById(Integer id){
    return recruitmentPositionService.selectPostionById(id);
  }
  @GetMapping("selectPostionByEnt")
  public Result selectPostionByEnt(String eid){
    return recruitmentPositionService.selectPostionByEnt(eid);
  }

  @GetMapping("selctPostionByCondition")
  public Result selctPostionByCondition(String math,Page<RecruitmentPosition> page){
    return recruitmentPositionService.selctPostionByCondition(math,page);
  }

}
