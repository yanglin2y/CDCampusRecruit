package com.ycode.cdcr.netty.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ycode.cdcr.base.entity.APUser;
import com.ycode.cdcr.common.web.entity.vo.Result;

public interface APUserService extends IService<APUser> {
    Result selectAPUser(Page<APUser> page);


}
