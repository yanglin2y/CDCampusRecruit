package com.ycode.cdcr.entcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ycode.cdcr.base.entity.RecruitmentPosition;
import com.ycode.cdcr.common.web.entity.vo.Result;

/**
 * @author YangLin
 * @createTime 2022/01/18
 */
public interface RecruitmentPositionService extends IService<RecruitmentPosition> {



  Result selectPostionByEnt(String eid);
  Result delPostion(Integer rpid);

}
