package com.ycode.cdcr.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
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
  private String entImg;
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createTime;
}
