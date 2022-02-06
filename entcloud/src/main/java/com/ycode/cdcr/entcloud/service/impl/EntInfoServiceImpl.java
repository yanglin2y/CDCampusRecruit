package com.ycode.cdcr.entcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycode.cdcr.base.entity.EntInfo;
import com.ycode.cdcr.base.mapper.EntInfoMapper;
import com.ycode.cdcr.base.vo.EntVo;
import com.ycode.cdcr.common.util.AESSimpleUtil;
import com.ycode.cdcr.common.util.SnowflakeIdWorker;
import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.entcloud.service.EntInfoService;
import com.ycode.cdcr.entcloud.util.UserUtil;
import java.time.LocalDateTime;
import java.util.Objects;
import org.springframework.beans.BeanUtils;
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
  public Result selectEntInfoByEid() {
    String eid = UserUtil.getLoginUser().getEid();
    EntInfo eid1 = entInfoService.getOne(new QueryWrapper<EntInfo>().eq("eid", eid));
    EntVo entVo = new EntVo();
    BeanUtils.copyProperties(eid1, entVo);

    return Result.success(entVo);
  }

  @Override
  public Result register(String entName, String account, String password) {
    EntInfo jugAccount = entInfoService.getOne(new QueryWrapper<EntInfo>().eq("account", account));
    if (Objects.isNull(jugAccount)) {
      EntInfo entInfo = EntInfo.builder().entName(entName).account(account)
          .password(AESSimpleUtil.encrypt(password)).createTime(
              LocalDateTime.now()).eid(SnowflakeIdWorker.getId().toString()).build();
      boolean save = entInfoService.save(entInfo);
      return save == true ? Result.success("注册成功") : Result.fail("注册失败，请重试");
    } else {
      return Result.fail("账号已存在");
    }
  }

  @Override
  public Result updataEntInfo(String entName, String companyIntroduction, String enterpriseLabel,
      String employeesNum, String address) {
    String eid = UserUtil.getLoginUser().getEid();
    EntInfo entInfo = EntInfo.builder().entName(entName).companyIntroduction(companyIntroduction)
        .enterpriseLabel(enterpriseLabel).employeesNum(employeesNum).address(address).build();
    boolean save = entInfoService.update(entInfo,new QueryWrapper<EntInfo>().eq("eid",eid));
    return save == true ? Result.success("注册成功") : Result.fail("注册失败，请重试");
  }

  @Override
  public Result updataPass(String password) {
    String eid = UserUtil.getLoginUser().getEid();
    EntInfo entInfo = EntInfo.builder()
        .password(AESSimpleUtil.encrypt(password)).build();
    boolean save = entInfoService.update(entInfo, new QueryWrapper<EntInfo>().eq("eid", eid));
    return save == true ? Result.success("修改成功",null ) : Result.fail("修改失败，请重试");
  }

}
