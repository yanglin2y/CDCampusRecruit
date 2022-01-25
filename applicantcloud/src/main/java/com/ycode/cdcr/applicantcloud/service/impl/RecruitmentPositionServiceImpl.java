package com.ycode.cdcr.applicantcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycode.cdcr.applicantcloud.service.RecruitmentPositionService;
import com.ycode.cdcr.base.entity.RecruitmentPosition;
import com.ycode.cdcr.base.mapper.RecruitmentPositionMapper;
import com.ycode.cdcr.common.web.entity.vo.Result;
import io.jsonwebtoken.lang.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
  public Result selectAllPosition() {
    List<RecruitmentPosition> list = recruitmentPositionService.list();
    if (Collections.isEmpty(list)) {
      return Result.fail("服务器繁忙，请稍后再试");
    }
    return Result.success("查询成功", list);
  }

  @Override
  public Result selectAllPositionByPage(Page<RecruitmentPosition> page) {
    return Result.success(recruitmentPositionService.page(page,
        new QueryWrapper<RecruitmentPosition>().eq("state", 1)));
  }

  @Override
  public Result selectPostionById(Integer id) {
    return Result.success(
        recruitmentPositionService.getOne(new QueryWrapper<RecruitmentPosition>().eq("rpid", id)));
  }

  @Override
  public Result selectPostionByEnt(String eid) {
    return Result.success(
        recruitmentPositionService.list(new QueryWrapper<RecruitmentPosition>().eq("eid", eid)));
  }

  @Override
  public Result selctPostionByCondition(String math, Page<RecruitmentPosition> page) {
    if (StringUtils.isEmpty(math)){
      Page<RecruitmentPosition> page1 = recruitmentPositionService.page(page);
      return Result.success(page1);
    }else{
      Page<RecruitmentPosition> page1 = recruitmentPositionService.page(page,
          new QueryWrapper<RecruitmentPosition>().like("rp_name", math).or().like("ent_name", math)
              .or().like("work_address", math));
      return Result.success(page1);
    }


  }
}
