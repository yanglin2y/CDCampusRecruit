package com.ycode.cdcr.hrcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycode.cdcr.base.entity.EntInfo;
import com.ycode.cdcr.base.entity.RecruitmentPosition;
import com.ycode.cdcr.base.mapper.RecruitmentPositionMapper;
import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.hrcloud.service.EntInfoService;
import com.ycode.cdcr.hrcloud.service.RecruitmentPositionService;
import com.ycode.cdcr.hrcloud.util.UserUtil;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YangLin
 * @createTime 2022/01/18
 */
@Service
public class RecruitmentPositionServiceImpl extends
    ServiceImpl<RecruitmentPositionMapper, RecruitmentPosition> implements
    RecruitmentPositionService {

  @Autowired
  RecruitmentPositionService recruitmentPositionService;
  @Autowired
  EntInfoService entInfoService;


  @Override
  public Result postJob(String eid, String rpName, String education, String salary,
      String workAddress, String experience, String jobResponsibilities) {
    String hrid = UserUtil.getLoginUser().getHrid();
    EntInfo obj = entInfoService.getOne(new QueryWrapper<EntInfo>().eq("eid", eid));
    RecruitmentPosition recruitmentPosition = RecruitmentPosition.builder().eid(eid)
        .entName(obj.getEntName()).state(1).createTime(LocalDateTime.now()).hrid(hrid)
        .rpName(rpName).education(education).salary(salary).workAddress(workAddress).entImg(obj.getEntImg())
        .experience(experience).jobResponsibilities(jobResponsibilities)
        .employeesNum(obj.getEmployeesNum()).build();
    boolean save = recruitmentPositionService.save(recruitmentPosition);
    return save == true ? Result.success(null) : Result.fail("发布失败，请重试");
  }

  @Override
  public Result selectRPByEid(String eid) {
    String hrid = UserUtil.getLoginUser().getHrid();
    List<RecruitmentPosition> list = recruitmentPositionService.list(
        new QueryWrapper<RecruitmentPosition>().eq("eid", eid).eq("hrid", hrid).eq("state",1));
    return Result.success(list);
  }
  @Override
  public Result delPostion(Integer rpid) {
    RecruitmentPosition recruitmentPosition = RecruitmentPosition.builder().state(0).build();
    boolean rpid1 = recruitmentPositionService.update(recruitmentPosition,
        new QueryWrapper<RecruitmentPosition>().eq("rpid", rpid));
    return rpid1 == true?Result.success("删除成功",null):Result.fail("删除失败");
  }
}
