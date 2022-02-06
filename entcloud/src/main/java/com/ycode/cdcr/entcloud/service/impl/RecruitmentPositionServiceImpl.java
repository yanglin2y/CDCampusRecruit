package com.ycode.cdcr.entcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycode.cdcr.base.entity.RecruitmentPosition;
import com.ycode.cdcr.base.mapper.RecruitmentPositionMapper;
import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.entcloud.service.RecruitmentPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YangLin
 * @createTime 2022/01/18
 */
@Service
public class RecruitmentPositionServiceImpl extends
    ServiceImpl<RecruitmentPositionMapper, RecruitmentPosition> implements
    RecruitmentPositionService {

  @Autowired
  RecruitmentPositionService recruitmentPositionService;


  @Override
  public Result selectPostionByEnt(String eid) {
    return Result.success(
        recruitmentPositionService.list(new QueryWrapper<RecruitmentPosition>().eq("eid", eid).eq("state",1)));
  }

  @Override
  public Result delPostion(Integer rpid) {
    RecruitmentPosition recruitmentPosition = RecruitmentPosition.builder().state(0).build();
    boolean rpid1 = recruitmentPositionService.update(recruitmentPosition,
        new QueryWrapper<RecruitmentPosition>().eq("rpid", rpid));
    return rpid1 == true?Result.success("删除成功",null):Result.fail("删除失败");
  }
}
