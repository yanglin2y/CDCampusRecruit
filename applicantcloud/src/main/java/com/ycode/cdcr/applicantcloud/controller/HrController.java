package com.ycode.cdcr.applicantcloud.controller;

import com.ycode.cdcr.applicantcloud.service.EntHrService;
import com.ycode.cdcr.common.web.entity.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
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

}
