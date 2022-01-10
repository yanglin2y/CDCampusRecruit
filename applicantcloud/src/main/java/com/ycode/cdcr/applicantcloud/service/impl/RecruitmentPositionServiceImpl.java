package com.ycode.cdcr.applicantcloud.service.impl;

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

/**
 * @author YangLin
 * @createTime 2022/01/18
 */
@Service
public class RecruitmentPositionServiceImpl extends ServiceImpl<RecruitmentPositionMapper, RecruitmentPosition> implements RecruitmentPositionService {
  @Autowired
  RecruitmentPositionService recruitmentPositionService;

  @Override
  public Result selectAllPosition() {
    List<RecruitmentPosition> list = recruitmentPositionService.list();
    if (Collections.isEmpty(list)){
      return Result.fail("服务器繁忙，请稍后再试");
    }
    return Result.success("查询成功",list);
  }

  @Override
  public Result selectAllPositionByPage(Page<RecruitmentPosition> page) {
    return Result.success(recruitmentPositionService.page(page));
  }
}
