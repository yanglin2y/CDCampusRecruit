package com.ycode.cdcr.hrcloud.controller;

import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.hrcloud.service.APUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangLin
 * @createTime 2022/02/07
 */
@RestController
@RequestMapping("apuser")
public class APUserController {
  @Autowired
  APUserService apUserService;

  @GetMapping("userInfo")
  public Result userInfo(String uid){
    return apUserService.userInfo(uid);
  }

}
