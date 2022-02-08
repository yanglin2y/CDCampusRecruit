package com.ycode.cdcr.hrcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ycode.cdcr.base.entity.EntHr;
import com.ycode.cdcr.common.web.entity.vo.Result;

public interface EntHrService extends IService<EntHr> {
  Result register(String account,String password,String hrName,String mail,Integer sex);
  Result loginTime();
  Result selectHrInfo();
  Result updataHrInfo(String hrName,String mail,Integer sex,String position,String depaReent);
  Result updataPass(String password);
  Result postHr(String eid,String entName);
}
