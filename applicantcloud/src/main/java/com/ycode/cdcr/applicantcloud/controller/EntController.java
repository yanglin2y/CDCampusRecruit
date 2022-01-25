package com.ycode.cdcr.applicantcloud.controller;

import com.ycode.cdcr.applicantcloud.service.EntInfoService;
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
@RequestMapping("ent")
public class EntController {

  @Autowired
  EntInfoService entInfoService;

  @GetMapping("selectEntInfoByEid")
  public Result selectEntInfoByEid(String eid){
    return entInfoService.selectEntInfoByEid(eid);
  }

}
