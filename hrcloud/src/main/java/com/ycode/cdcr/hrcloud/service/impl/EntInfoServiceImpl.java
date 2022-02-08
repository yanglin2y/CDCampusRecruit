package com.ycode.cdcr.hrcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycode.cdcr.base.entity.EntInfo;
import com.ycode.cdcr.base.mapper.EntInfoMapper;
import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.hrcloud.service.EntInfoService;
import java.util.List;
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
  public Result selectEntInfoByEntName(String entName) {
    List<EntInfo> entName1 = entInfoService.list(new QueryWrapper<EntInfo>().like("ent_name", entName));
    return Result.success(entName1);
  }
}
