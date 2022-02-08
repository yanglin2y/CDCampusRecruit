package com.ycode.cdcr.hrcloud.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ycode.cdcr.base.entity.APUser;
import com.ycode.cdcr.common.web.entity.vo.Result;

public interface APUserService extends IService<APUser> {



  Result userInfo(String uid);


}
