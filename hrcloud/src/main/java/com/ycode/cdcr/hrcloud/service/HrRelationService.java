package com.ycode.cdcr.hrcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ycode.cdcr.base.entity.HrRelation;
import com.ycode.cdcr.common.web.entity.vo.Result;

public interface HrRelationService extends IService<HrRelation> {
  Result addRelation(String uid,String apName,String apImg);
  Result selectRelation();

}
