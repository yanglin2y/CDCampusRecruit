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
 * hr表
 */
@TableName("ent_hr")
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class EntHr implements Serializable {

  private static final long serialVersionUID = -143482793007401833L;
  @TableId(type = IdType.AUTO)
  private Integer id;
  private String hrid;
  private String eid;
  private String entName;
  private String account;
  private String password;
  private Integer sex;
  private String mail;
  private String hrName;
  private String position;
  private String department;
  private String hrImg;
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime lastLogin;
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createTime;
}
