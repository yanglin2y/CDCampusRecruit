package com.ycode.cdcr.hrcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycode.cdcr.base.entity.APResume;
import com.ycode.cdcr.base.entity.HrResume;
import com.ycode.cdcr.base.mapper.APResumeMapper;
import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.hrcloud.service.APResumeService;
import com.ycode.cdcr.hrcloud.service.HrResumeService;
import com.ycode.cdcr.hrcloud.util.UserUtil;
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
  @Autowired
  HrResumeService hrResumeService;
  @Override
  public Result updataApResume(String uid, String rpid) {
    APResume apResume = APResume.builder().state(1).build();
    boolean update = apResumeService.update(apResume,
          new QueryWrapper<APResume>().eq("uid", uid).eq("rpid", rpid));
    return update==true?Result.success(null):Result.fail("更新失败");
  }

  @Override
  public Result passApResume(String uid, String rpid) {
    String hrid = UserUtil.getLoginUser().getHrid();
    APResume apResume = APResume.builder().state(2).build();
    boolean update = apResumeService.update(apResume,
        new QueryWrapper<APResume>().eq("uid", uid).eq("rpid", rpid));
    HrResume hrResume = HrResume.builder().state(1).hrid(hrid).build();
    boolean update2 = hrResumeService.update(hrResume,
        new QueryWrapper<HrResume>().eq("uid", uid).eq("rpid", rpid));

    return update==true&&update2==true?Result.success(null):Result.fail("通过失败，请重试");
  }

  @Override
  public Result delApResume(String uid, String rpid) {
    String hrid = UserUtil.getLoginUser().getHrid();
    APResume apResume = APResume.builder().state(3).build();
    boolean update = apResumeService.update(apResume,
        new QueryWrapper<APResume>().eq("uid", uid).eq("rpid", rpid));
    HrResume hrResume = HrResume.builder().state(2).hrid(hrid).build();
    boolean update2 = hrResumeService.update(hrResume,
        new QueryWrapper<HrResume>().eq("uid", uid).eq("rpid", rpid));
    return update==true&&update2==true?Result.success(null):Result.fail("拒绝失败，请重试");
  }
}
