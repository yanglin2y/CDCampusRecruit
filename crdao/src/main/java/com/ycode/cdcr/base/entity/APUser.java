package com.ycode.cdcr.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author YangLin
 * @createTime 2022/01/08
 * 应聘者登陆信息表
 */

@TableName("ap_user")
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class APUser implements Serializable {

  private static final long serialVersionUID = -1867031398166050867L;
  @TableId(type = IdType.AUTO)
  private Integer id;
  private Long uid;
  private String apName;
  private String password;
  private String account;
  private Integer age;
  private LocalDate birthday;
  private Integer sex;
  private String city;
  private String iphone;
  private String mail;
  private String apImg;
  private LocalDate createTime;
}
