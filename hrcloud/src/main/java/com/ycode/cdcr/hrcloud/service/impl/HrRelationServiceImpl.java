package com.ycode.cdcr.hrcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycode.cdcr.base.entity.HrRelation;
import com.ycode.cdcr.base.mapper.HrRelationMapper;
import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.hrcloud.service.HrRelationService;
import com.ycode.cdcr.hrcloud.util.UserUtil;
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
public class HrRelationServiceImpl extends ServiceImpl<HrRelationMapper, HrRelation> implements
    HrRelationService {

  @Autowired
  HrRelationService hrRelationService;
  @Override
  public Result addRelation(String uid, String apName, String apImg) {
    String hrid = UserUtil.getLoginUser().getHrid();
    HrRelation one = hrRelationService.getOne(
        new QueryWrapper<HrRelation>().eq("uid", uid).eq("hrid", hrid));
    if (Objects.isNull(one)){
      HrRelation apRelation = HrRelation.builder().uid(uid).createTime(LocalDateTime.now()).hrid(hrid).apName(apName).apImg(apImg).build();
      boolean save = hrRelationService.save(apRelation);
      return Result.success(null);
    }else{
      return Result.success(null);
    }

  }

  @Override
  public Result selectRelation() {
    String hrid = UserUtil.getLoginUser().getHrid();
    List<HrRelation> hrid1 = hrRelationService.list(new QueryWrapper<HrRelation>().eq("hrid", hrid));
    return Result.success(hrid1);
  }
}
