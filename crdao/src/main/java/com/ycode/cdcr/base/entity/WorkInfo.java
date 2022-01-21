package com.ycode.cdcr.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
  private String uid;
  private String entName;
  private String entIndustry;
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  private LocalDate startTime;
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  private LocalDate endTime;
  private String occupation;
  private String department;
  private String content;
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createTime;
}
