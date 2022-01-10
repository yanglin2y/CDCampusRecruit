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
  private Long uid;
  private String projectExperience;
  private String projectDescription;
  @JSONField(format = "yyyy-MM-dd")
  private LocalDate startTime;
  @JSONField(format = "yyyy-MM-dd")
  private LocalDate endTime;
  private String content;
  private LocalDate createTime;
}
