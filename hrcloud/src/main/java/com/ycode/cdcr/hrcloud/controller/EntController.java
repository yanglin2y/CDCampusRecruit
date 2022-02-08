package com.ycode.cdcr.hrcloud.controller;

import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.hrcloud.service.EntInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangLin
 * @createTime 2022/02/08
 */
@RestController
@RequestMapping("ent")
public class EntController {

  @Autowired
  EntInfoService entInfoService;
  @GetMapping("selectEntInfoByEntName")
  public Result selectEntInfoByEntName(String entName){
    return entInfoService.selectEntInfoByEntName(entName);
  }

}
