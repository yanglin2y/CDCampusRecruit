package com.ycode.cdcr.base.entity;

import com.alibaba.fastjson.annotation.JSONField;
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
 * 教育信息表
 */
@TableName("education_info")
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class EducationInfo implements Serializable {

  private static final long serialVersionUID = -4546696076550078790L;
  @TableId(type = IdType.AUTO)
  private Integer id;
  private Long uid;
  private String education;
  private String school;
  private String major;
  @JSONField(format = "yyyy-MM-dd")
  private LocalDate startTime;
  @JSONField(format = "yyyy-MM-dd")
  private LocalDate endTime;
  private LocalDate createTime;
}
