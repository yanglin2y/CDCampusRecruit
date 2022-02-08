package com.ycode.cdcr.hrcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycode.cdcr.base.entity.HrResume;
import com.ycode.cdcr.base.mapper.HrResumeMapper;
import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.hrcloud.service.HrResumeService;
import com.ycode.cdcr.hrcloud.util.UserUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YangLin
 * @createTime 2022/02/07
 */
@Service
public class HrResumeServiceImpl extends ServiceImpl< HrResumeMapper,HrResume>  implements
    HrResumeService {

  @Autowired
  HrResumeService hrResumeService;
  @Override
  public Result selectHrResume(Integer rpid) {
    List<HrResume> list = hrResumeService.list(new QueryWrapper<HrResume>().eq("rpid", rpid).eq("state",0));
    return Result.success(list);
  }

  @Override
  public Result selectHrResumeByHrid() {
    String hrid = UserUtil.getLoginUser().getHrid();
    List<HrResume> list = hrResumeService.list(new QueryWrapper<HrResume>().eq("hrid", hrid));
    return Result.success(list);
  }
}
