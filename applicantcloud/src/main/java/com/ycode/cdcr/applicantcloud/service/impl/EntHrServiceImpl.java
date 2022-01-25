package com.ycode.cdcr.applicantcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycode.cdcr.applicantcloud.service.EntHrService;
import com.ycode.cdcr.base.entity.EntHr;
import com.ycode.cdcr.base.mapper.EntHrMapper;
import com.ycode.cdcr.base.vo.HrVo;
import com.ycode.cdcr.common.web.entity.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YangLin
 * @createTime 2022/01/21
 */
@Service
public class EntHrServiceImpl extends ServiceImpl<EntHrMapper, EntHr> implements EntHrService {

  @Autowired
  EntHrService entHrService;
  @Override
  public Result selectHrInfoByHrId(String hrId) {
    HrVo hrvo = new HrVo();
    EntHr hridList = entHrService.getOne(new QueryWrapper<EntHr>().eq("hrid", hrId));
    BeanUtils.copyProperties(hridList,hrvo);

    return  Result.success(hrvo);
  }
}
