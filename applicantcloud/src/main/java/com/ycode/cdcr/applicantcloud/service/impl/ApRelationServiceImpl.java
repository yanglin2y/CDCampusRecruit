package com.ycode.cdcr.applicantcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycode.cdcr.applicantcloud.service.ApRelationService;
import com.ycode.cdcr.applicantcloud.util.UserUtil;
import com.ycode.cdcr.base.entity.ApRelation;
import com.ycode.cdcr.base.mapper.ApRelationMapper;
import com.ycode.cdcr.common.web.entity.vo.Result;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YangLin
 * @createTime 2022/02/09
 */
@Service
public class ApRelationServiceImpl extends ServiceImpl<ApRelationMapper, ApRelation> implements
    ApRelationService {

  @Autowired
  ApRelationService apRelationService;
  @Override
  public Result addRelation(String hrid, String hrName, String hrImg) {
    String uid = UserUtil.getLoginUser().getUid();
    ApRelation one = apRelationService.getOne(
        new QueryWrapper<ApRelation>().eq("uid", uid).eq("hrid", hrid));
    if (Objects.isNull(one)){
      ApRelation apRelation = ApRelation.builder().uid(uid).createTime(LocalDateTime.now()).hrid(hrid).hrName(hrName).hrImg(hrImg).build();
      boolean save = apRelationService.save(apRelation);
      return Result.success(null);
    }else{
      return Result.success(null);
    }

  }

  @Override
  public Result selectRelation() {
    String uid = UserUtil.getLoginUser().getUid();
    List<ApRelation> uid1 = apRelationService.list(new QueryWrapper<ApRelation>().eq("uid", uid));
    return Result.success(uid1);
  }
}
