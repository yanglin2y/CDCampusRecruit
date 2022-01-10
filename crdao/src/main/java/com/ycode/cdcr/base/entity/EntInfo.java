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
 */
@TableName("ent_info")
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class EntInfo implements Serializable {

  private static final long serialVersionUID = -2629972031975670474L;

  @TableId(type = IdType.AUTO)
  private Integer id;
  private String eid;
  private String account;
  private String password;
  private String entName;
  private String companyIntroduction;
  private String productIntroduction;
  private Integer employeesNum;
  private String enterpriseLabel;
  private String address;
  private LocalDate createTime;
}
