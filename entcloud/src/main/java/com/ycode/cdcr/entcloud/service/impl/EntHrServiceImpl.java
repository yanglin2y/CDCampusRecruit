package com.ycode.cdcr.entcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycode.cdcr.base.entity.EntHr;
import com.ycode.cdcr.base.entity.RecruitmentPosition;
import com.ycode.cdcr.base.mapper.EntHrMapper;
import com.ycode.cdcr.base.vo.HrVo;
import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.entcloud.service.EntHrService;
import com.ycode.cdcr.entcloud.service.RecruitmentPositionService;
import com.ycode.cdcr.entcloud.util.UserUtil;
import java.util.List;
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
  @Autowired
  RecruitmentPositionService recruitmentPositionService;
  @Override
  public Result selectHrInfoByHrId(String hrId) {
    HrVo hrvo = new HrVo();
    EntHr hridList = entHrService.getOne(new QueryWrapper<EntHr>().eq("hrid", hrId));
    BeanUtils.copyProperties(hridList,hrvo);

    return  Result.success(hrvo);
  }

  @Override
  public Result selectHrInfoByEid() {
    String eid = UserUtil.getLoginUser().getEid();
    List<EntHr> list = entHrService.list(new QueryWrapper<EntHr>().eq("eid", eid).eq("state",0));
    return  Result.success(list);
  }

  @Override
  public Result selectHrInfoByEidList() {
    String eid = UserUtil.getLoginUser().getEid();
    List<EntHr> list = entHrService.list(new QueryWrapper<EntHr>().eq("eid", eid).eq("state",1));
    return  Result.success(list);
  }

  @Override
  public Result agreeHr(String hrid) {
    EntHr entHr  = EntHr.builder().state(1).build();
    boolean save = entHrService.update(entHr, new QueryWrapper<EntHr>().eq("hrid", hrid));
    return save == true ? Result.success("通过审核") : Result.fail("审核失败，请重试");
  }

  @Override
  public Result rejectHr(String hrid) {
    EntHr entHr  = EntHr.builder().state(2).build();
    boolean save = entHrService.update(entHr, new QueryWrapper<EntHr>().eq("hrid", hrid));
    return save == true ? Result.success("通过审核") : Result.fail("审核失败，请重试");
  }

  @Override
  public Result delHr(String hrid) {
    String eid = UserUtil.getLoginUser().getEid();
    EntHr entHr  = EntHr.builder().state(0).eid("").entName("").build();
    boolean save1 = entHrService.update(entHr, new QueryWrapper<EntHr>().eq("hrid", hrid));
    boolean save2 = recruitmentPositionService.remove(
        new QueryWrapper<RecruitmentPosition>().eq("eid", eid).eq("hrid", hrid));
    return save1 == true ? Result.success("删除成功") : Result.fail("删除失败，请重试");
  }
}
