package com.ycode.cdcr.applicantcloud.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ycode.cdcr.base.entity.RecruitmentPosition;
import com.ycode.cdcr.common.web.entity.vo.Result;

/**
 * @author YangLin
 * @createTime 2022/01/18
 */
public interface RecruitmentPositionService extends IService<RecruitmentPosition> {

  Result selectAllPosition();

  Result selectAllPositionByPage(Page<RecruitmentPosition> page);

  Result selectPostionById(Integer id);

  Result selectPostionByEnt(String eid);

  Result selctPostionByCondition(String math,Page<RecruitmentPosition> page);

}
