package com.ycode.cdcr.netty.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ycode.cdcr.base.entity.APUser;
import com.ycode.cdcr.base.entity.EntHr;
import com.ycode.cdcr.base.entity.EntInfo;
import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.netty.service.EntInfoService;
import com.ycode.cdcr.netty.service.APUserService;
import com.ycode.cdcr.netty.service.EntHrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangLin
 * @createTime 2022/02/10
 */
@RestController
@RequestMapping("info")
public class InfoController {
  @Autowired
  EntInfoService entInfoService;
  @Autowired
  EntHrService entHrService;
  @Autowired
  APUserService apUserService;

  @GetMapping("selectAPUser")
  Result selectAPUser(Page<APUser> page){
    return apUserService.selectAPUser(page);
  }
  @GetMapping("selectHr")
  Result selectHr(Page<EntHr> page){
    return entHrService.selectHr(page);
  }
    @GetMapping("selectEnt")
  Result selectEnt(Page<EntInfo> page){
    return entInfoService.selectEnt(page);
  }
}
