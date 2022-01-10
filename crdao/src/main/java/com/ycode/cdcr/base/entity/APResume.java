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
@TableName("ap_resume")
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class APResume implements Serializable {


  private static final long serialVersionUID = 5255138903701584407L;
  @TableId(type = IdType.AUTO)
  private Integer id;
  private String uid;
  private String eid;
  private String hrid;
  private Integer state;
  private LocalDate createTime;
}
