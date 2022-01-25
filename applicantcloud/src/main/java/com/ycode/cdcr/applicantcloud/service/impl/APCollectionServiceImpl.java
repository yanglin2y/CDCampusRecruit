package com.ycode.cdcr.applicantcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycode.cdcr.applicantcloud.service.APCollectionService;
import com.ycode.cdcr.applicantcloud.service.RecruitmentPositionService;
import com.ycode.cdcr.applicantcloud.util.UserUtil;
import com.ycode.cdcr.base.entity.APCollection;
import com.ycode.cdcr.base.entity.RecruitmentPosition;
import com.ycode.cdcr.base.mapper.APCollectionMapper;
import com.ycode.cdcr.common.web.entity.vo.Result;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * @author YangLin
 * @createTime 2022/01/22
 */
@Service
public class APCollectionServiceImpl extends
    ServiceImpl<APCollectionMapper, APCollection> implements
    APCollectionService {

  @Autowired
  RecruitmentPositionService recruitmentPositionService;
  @Autowired
  APCollectionService APCollectionService;

  @Override
  public Result selectCollection() {
    String uid = UserUtil.getLoginUser().getUid();
    List<APCollection> APCollections = APCollectionService.list(
        new QueryWrapper<APCollection>().eq("uid", uid));
    List<Integer> collect = APCollections.stream().map(APCollection::getRpid)
        .collect(Collectors.toList());
    if (CollectionUtils.isEmpty(collect)) {
      return Result.success(null);
    } else {
      List<RecruitmentPosition> list = recruitmentPositionService.list(
          new QueryWrapper<RecruitmentPosition>().in("rpid", collect));
      return Result.success(list);
    }

  }

  @Override
  public Result addCollection(Integer rpid) {
    String uid = UserUtil.getLoginUser().getUid();
    APCollection apCollection = APCollection.builder().rpid(rpid).uid(uid)
        .createTime(LocalDateTime.now()).build();
    return APCollectionService.save(apCollection) == true ? Result.success("添加成功")
        : Result.fail("添加失败");
  }

  @Override
  public Result delCollection(Integer rpid) {
    String uid = UserUtil.getLoginUser().getUid();
    return APCollectionService.remove(new QueryWrapper<APCollection>().eq("rpid", rpid)) == true
        ? Result.success("删除成功") : Result.fail("删除失败");
  }
}
