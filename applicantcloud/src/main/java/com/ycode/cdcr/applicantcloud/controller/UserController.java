package com.ycode.cdcr.applicantcloud.controller;

import com.ycode.cdcr.applicantcloud.service.APUserService;
import com.ycode.cdcr.common.web.entity.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangLin
 * @createTime 2022/01/14
 */
@RequestMapping("user")
@RestController
public class UserController {

  @Autowired
  APUserService apUserService;

  @PostMapping("registerAPUser")
  public Result registerAPUser(String apName, String account, String password,
      String iphone, String mail){
    return apUserService.registerAPUser(apName, account, password,iphone, mail);
  }
  @GetMapping("info")
  public Result userInfo(){
    return apUserService.userInfo();
  }
  @PostMapping("updataUser")
  Result updataAPUser(Integer id,String apName, Integer sex, String birthday,
      String city, String iphone, String mail, String apImg){
    return apUserService.updataAPUser(id, apName, sex, birthday, city, iphone, mail, apImg);
  }
  @PostMapping("updataPass")
  Result updataPass(String password){
    return apUserService.updataPass(password);
  }
}
