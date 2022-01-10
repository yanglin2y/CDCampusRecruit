package com.ycode.cdcr.applicantcloud.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ycode.cdcr.base.entity.APUser;
import com.ycode.cdcr.common.web.entity.vo.Result;

public interface APUserService extends IService<APUser> {

  Result registerAPUser(String apName, String account, String password,
      String iphone, String mail);

  Result userInfo();

  Result updataAPUser(Integer id,String apName, Integer sex, String birthday,
      String city, String iphone, String mail, String apImg);
}
