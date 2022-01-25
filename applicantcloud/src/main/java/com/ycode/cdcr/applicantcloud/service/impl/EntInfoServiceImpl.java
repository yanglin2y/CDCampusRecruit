package com.ycode.cdcr.applicantcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycode.cdcr.applicantcloud.service.EntInfoService;
import com.ycode.cdcr.base.entity.EntInfo;
import com.ycode.cdcr.base.mapper.EntInfoMapper;
import com.ycode.cdcr.common.web.entity.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YangLin
 * @createTime 2022/01/21
 */
@Service
public class EntInfoServiceImpl extends ServiceImpl<EntInfoMapper, EntInfo> implements
    EntInfoService {

  @Autowired
  EntInfoService entInfoService;
  @Override
  public Result selectEntInfoByEid(String eid) {
    EntInfo eid1 = entInfoService.getOne(new QueryWrapper<EntInfo>().eq("eid", eid));
    return Result.success(eid1);
  }

}
