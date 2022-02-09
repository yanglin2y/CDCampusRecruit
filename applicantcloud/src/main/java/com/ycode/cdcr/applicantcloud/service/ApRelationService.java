package com.ycode.cdcr.applicantcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ycode.cdcr.base.entity.ApRelation;
import com.ycode.cdcr.common.web.entity.vo.Result;

public interface ApRelationService extends IService<ApRelation> {
  Result addRelation(String hrid,String hrName,String hrImg);
  Result selectRelation();

}
