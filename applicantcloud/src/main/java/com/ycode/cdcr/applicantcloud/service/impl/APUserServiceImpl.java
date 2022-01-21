package com.ycode.cdcr.applicantcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycode.cdcr.applicantcloud.service.APUserService;
import com.ycode.cdcr.applicantcloud.util.UserUtil;
import com.ycode.cdcr.base.entity.APUser;
import com.ycode.cdcr.base.mapper.APUserMapper;
import com.ycode.cdcr.base.vo.UserInfoVo;
import com.ycode.cdcr.common.util.AESSimpleUtil;
import com.ycode.cdcr.common.util.SnowflakeIdWorker;
import com.ycode.cdcr.common.web.entity.vo.Result;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author YangLin
 * @createTime 2022/01/10
 */
@Service
public class APUserServiceImpl extends ServiceImpl<APUserMapper, APUser> implements APUserService {

  @Autowired
  APUserService apUserService;

  /**
   *注册应聘者
   */
  @Override
  public Result registerAPUser(String apName, String account, String password,
     String iphone, String mail) {
    APUser apUserServiceOne = apUserService.getOne(
        new QueryWrapper<APUser>().eq("account", account));
    if (!ObjectUtils.isEmpty(apUserServiceOne)){
      return Result.fail("登陆账户已经存在");
    }
    APUser apUser = APUser.builder().apName(apName).account(account).password(AESSimpleUtil.encrypt(password)).
        iphone(iphone).mail(mail).createTime(LocalDateTime.now()).uid(
            SnowflakeIdWorker.getId().toString())
        .build();
    boolean save = apUserService.save(apUser);
    return save == true? Result.success("注册成功",null): Result.fail("注册失败");
  }

  @Override
  public Result userInfo() {
    String uid = UserUtil.getLoginUser().getUid();
    APUser apUserServiceOne = apUserService.getOne(
        new QueryWrapper<APUser>().eq("uid", UserUtil.getLoginUser().getUid()));
    UserInfoVo userInfoVo = new UserInfoVo();
    BeanUtils.copyProperties(apUserServiceOne,userInfoVo);
    return Result.success(userInfoVo);
  }

  @Override
  public Result updataAPUser(Integer id, String apName, Integer sex, String birthday,
      String city, String iphone, String mail, String apImg) {
    String uid = UserUtil.getLoginUser().getUid();
    LocalDate newStartTime = LocalDate.parse(birthday,
        DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    APUser apUser = APUser.builder().apName(apName).
        iphone(iphone).mail(mail).apImg(apImg).sex(sex).birthday(newStartTime).city(city).build();
    boolean save =    apUserService.update(apUser,new QueryWrapper<APUser>().eq("uid",uid).eq("id",id));
    return save == true? Result.success("保存成功"): Result.fail("保存失败");

  }

}
