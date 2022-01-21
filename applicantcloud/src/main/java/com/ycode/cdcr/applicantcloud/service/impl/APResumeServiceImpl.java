package com.ycode.cdcr.applicantcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycode.cdcr.applicantcloud.service.APResumeService;
import com.ycode.cdcr.applicantcloud.util.UserUtil;
import com.ycode.cdcr.base.entity.APResume;
import com.ycode.cdcr.base.mapper.APResumeMapper;
import com.ycode.cdcr.common.web.entity.vo.Result;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YangLin
 * @createTime 2022/01/21
 */
@Service
public class APResumeServiceImpl extends ServiceImpl<APResumeMapper, APResume> implements
    APResumeService {
  @Autowired
  APResumeService apResumeService;
  @Override
  public Result selectAPResumeByUid(Integer state) {
    String uid = UserUtil.getLoginUser().getUid();
    List<APResume> list = apResumeService.list(new QueryWrapper<APResume>().eq("uid", uid).eq("state",state));
    return Result.success(list);
  }
}
