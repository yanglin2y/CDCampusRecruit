package com.ycode.cdcr.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author YangLin
 * @createTime 2022/01/08 项目经历表
 */

@TableName("project_info")
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class ProjectInfo implements Serializable {

  private static final long serialVersionUID = -8826105011486107493L;
  @TableId(type = IdType.AUTO)
  private Integer id;
  private String uid;
  private String projectName;
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  private LocalDate startTime;
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  private LocalDate endTime;
  private String content;
  private LocalDate createTime;
}
