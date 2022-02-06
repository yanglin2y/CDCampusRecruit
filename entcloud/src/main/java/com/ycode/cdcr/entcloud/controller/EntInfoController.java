package com.ycode.cdcr.entcloud.controller;

import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.entcloud.service.EntInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangLin
 * @createTime 2022/01/26
 */
@RestController
@RequestMapping("user")
public class EntInfoController {

  @Autowired
  EntInfoService entInfoService;

  @PostMapping("register")
  public Result register(String entName, String account, String password) {
    return entInfoService.register(entName, account, password);
  }

  @GetMapping("getEntInfo")
  public Result selectEntInfoByEid() {
    return entInfoService.selectEntInfoByEid();
  }

  @PostMapping("updataEntInfo")
  public Result updataEntInfo(String entName, String companyIntroduction, String enterpriseLabel,
      String employeesNum, String address) {
    return entInfoService.updataEntInfo(entName, companyIntroduction, enterpriseLabel, employeesNum,
        address);
  }
  @PostMapping("updataPass")
  public Result updataPass(String password){
    return entInfoService.updataPass(password);
  }
}
