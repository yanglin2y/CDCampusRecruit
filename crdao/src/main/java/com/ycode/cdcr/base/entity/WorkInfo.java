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
 * 工作经历表
 */
@TableName("work_info")
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class WorkInfo implements Serializable {

  private static final long serialVersionUID = -590802250743747093L;

  @TableId(type = IdType.AUTO)
  private Integer id;
  private Long uid;
  private String entName;
  private String entIndustry;
  @JSONField(format = "yyyy-MM-dd")
  private LocalDate startTime;
  @JSONField(format = "yyyy-MM-dd")
  private LocalDate endTime;
  private String occupation;
  private String department;
  private String content;
  private LocalDate createTime;
}
