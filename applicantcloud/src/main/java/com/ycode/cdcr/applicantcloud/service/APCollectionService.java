package com.ycode.cdcr.applicantcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ycode.cdcr.base.entity.APCollection;
import com.ycode.cdcr.common.web.entity.vo.Result;


public interface APCollectionService extends IService<APCollection> {

  Result selectCollection();
  Result addCollection(Integer rpid);
  Result delCollection(Integer rpid);

}
