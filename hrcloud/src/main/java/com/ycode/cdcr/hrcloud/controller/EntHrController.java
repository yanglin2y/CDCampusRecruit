package com.ycode.cdcr.hrcloud.controller;

import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.hrcloud.service.EntHrService;
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
@RequestMapping("user")
public class EntHrController {

  @Autowired
  EntHrService entHrService;

  @PostMapping("register")
  Result register(String account,String password,String hrName,String mail,Integer sex){
    return entHrService.register(account, password, hrName, mail, sex);
  }

  @GetMapping("selectHrInfo")
  Result selectHrInfo(){
    return entHrService.selectHrInfo();
  }
  @PostMapping("updataHrInfo")
  public Result updataHrInfo(String hrName,String mail,Integer sex,String position,String department){
    return entHrService.updataHrInfo(hrName, mail, sex, position, department);
  }
  @PostMapping("updataPass")
  public Result updataPass(String password){
    return entHrService.updataPass(password);
  }
  @PostMapping("postHr")
  public Result postHr(String eid,String entName){
    return entHrService.postHr(eid,entName);
  }
}
