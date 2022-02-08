package com.ycode.cdcr.hrcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycode.cdcr.base.entity.EntHr;
import com.ycode.cdcr.base.mapper.EntHrMapper;
import com.ycode.cdcr.base.vo.HrVo;
import com.ycode.cdcr.common.util.AESSimpleUtil;
import com.ycode.cdcr.common.util.SnowflakeIdWorker;
import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.hrcloud.service.EntHrService;
import com.ycode.cdcr.hrcloud.util.UserUtil;
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
public class EntHrServiceImpl extends ServiceImpl<EntHrMapper, EntHr> implements EntHrService {

  @Autowired
  EntHrService entHrService;

  @Override
  public Result register(String account, String password, String hrName, String mail, Integer sex) {
    EntHr jugAccount = entHrService.getOne(new QueryWrapper<EntHr>().eq("account", account));
    if (Objects.isNull(jugAccount)) {
      EntHr entHr = EntHr.builder().account(account).password(AESSimpleUtil.encrypt(password))
          .hrName(hrName).mail(mail).sex(sex).createTime(
              LocalDateTime.now()).hrid(SnowflakeIdWorker.getId().toString()).build();
      boolean save = entHrService.save(entHr);
      return save == true ? Result.success(null) : Result.fail("注册失败，请重试");
    }else{
      return Result.fail("账号已存在");
    }
  }
  @Override
  public Result selectHrInfo() {
    String hrid = UserUtil.getLoginUser().getHrid();
    EntHr hrid1 = entHrService.getOne(new QueryWrapper<EntHr>().eq("hrid", hrid));
    HrVo hrVo = new HrVo();
    BeanUtils.copyProperties(hrid1, hrVo);
    return Result.success(hrVo);
  }

  @Override
  public Result updataHrInfo(String hrName,String mail,Integer sex,String position,String department) {
    String hrid = UserUtil.getLoginUser().getHrid();
    EntHr entHr = EntHr.builder().hrName(hrName).mail(mail).sex(sex).position(position).department(department).build();
    boolean hrid1 = entHrService.update(entHr, new QueryWrapper<EntHr>().eq("hrid", hrid));
    return hrid1 == true?Result.success(null):Result.fail("保存失败请重试");
  }

  @Override
  public Result updataPass(String password) {
    String hrid = UserUtil.getLoginUser().getHrid();
    EntHr entInfo = EntHr.builder()
        .password(AESSimpleUtil.encrypt(password)).build();
    boolean save = entHrService.update(entInfo, new QueryWrapper<EntHr>().eq("hrid", hrid));
    return save == true ? Result.success("修改成功",null ) : Result.fail("修改失败，请重试");
  }


  @Override
  public Result loginTime() {
    String hrid = UserUtil.getLoginUser().getHrid();
    EntHr entHr = EntHr.builder().lastLogin(LocalDateTime.now()).build();
    entHrService.update(entHr,new QueryWrapper<EntHr>().eq("hrid",hrid));
    return Result.success(null);
  }
  @Override
  public Result postHr(String eid, String entName) {
    String hrid = UserUtil.getLoginUser().getHrid();
    EntHr entHr = EntHr.builder().eid(eid).entName(entName).state(0).build();
    boolean save = entHrService.update(entHr, new QueryWrapper<EntHr>().eq("hrid", hrid));
    return save == true ? Result.success("申请成功",null ) : Result.fail("申请失败，请重试");
  }
}
