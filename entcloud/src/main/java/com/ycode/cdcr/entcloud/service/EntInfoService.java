package com.ycode.cdcr.entcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ycode.cdcr.base.entity.EntInfo;
import com.ycode.cdcr.common.web.entity.vo.Result;

public interface EntInfoService extends IService<EntInfo> {

  Result selectEntInfoByEid();

  Result register(String entName, String account, String password);

  Result updataEntInfo(String entName, String companyIntroduction, String enterpriseLabel,
      String employeesNum, String address);
  Result updataPass(String password);
}
