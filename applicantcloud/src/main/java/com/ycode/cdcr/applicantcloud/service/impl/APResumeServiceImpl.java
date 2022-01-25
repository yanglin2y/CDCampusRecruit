package com.ycode.cdcr.applicantcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycode.cdcr.applicantcloud.service.APResumeService;
import com.ycode.cdcr.applicantcloud.util.UserUtil;
import com.ycode.cdcr.base.entity.APResume;
import com.ycode.cdcr.base.mapper.APResumeMapper;
import com.ycode.cdcr.common.web.entity.vo.Result;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
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
    List<APResume> list = apResumeService.list(
        new QueryWrapper<APResume>().eq("uid", uid).eq("state", state));
    return Result.success(list);
  }

  @Override
  public Result selectAllAPResume() {
    String uid = UserUtil.getLoginUser().getUid();
    return Result.success(apResumeService.list(new QueryWrapper<APResume>().eq("uid", uid)));
  }

  @Override
  public Result jugResume(Integer rpid) {
    String uid = UserUtil.getLoginUser().getUid();
    APResume rp = apResumeService.getOne(
        new QueryWrapper<APResume>().eq("rpid", rpid).eq("uid", uid));
    if (Objects.isNull(rp)) {
      return Result.success(false);
    } else {
      return Result.success(true);
    }
  }

  @Override
  public Result addResume(String eid, String hrid, String rpid, String rpName, String workAddress,
      String education, String salary, String entName, String experience, String entImg,
      Integer state) {
    String uid = UserUtil.getLoginUser().getUid();
    APResume apResume = APResume.builder().eid(eid).hrid(hrid).rpid(rpid).rpName(rpName)
        .workAddress(workAddress).education(education).salary(salary).entName(entName)
        .experience(experience).entImg(entImg).state(0).createTime(LocalDateTime.now()).uid(uid).build();
    boolean save = apResumeService.save(apResume);
    return save == true?Result.success("投递成功",null):Result.fail("投递失败");
  }
}
