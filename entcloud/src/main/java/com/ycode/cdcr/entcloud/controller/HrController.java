package com.ycode.cdcr.entcloud.controller;

import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.entcloud.service.EntHrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangLin
 * @createTime 2022/01/21
 */
@RestController
@RequestMapping("hr")
public class HrController {

  @Autowired
  EntHrService entHrService;

  @RequestMapping("selectHrInfoByHrId")
  public Result selectHrInfoByHrId(String hrid){
    return entHrService.selectHrInfoByHrId(hrid);
  }

  @GetMapping("selectHrInfoByEidList")
  public Result selectHrInfoByEidList() {
    return entHrService.selectHrInfoByEidList();
  }
  @RequestMapping("selectHrInfoByEid")
  Result selectHrInfoByEid(){
    return entHrService.selectHrInfoByEid();
  }
  @PostMapping("agreeHr")
  Result agreeHr(String hrid){
    return entHrService.agreeHr(hrid);
  }
  @PostMapping("rejectHr")
  Result rejectHr(String hrid){
    return entHrService.rejectHr(hrid);
  }
  @PostMapping("delHr")
  public Result delHr(String hrid){
    return entHrService.delHr(hrid);
  }
}
