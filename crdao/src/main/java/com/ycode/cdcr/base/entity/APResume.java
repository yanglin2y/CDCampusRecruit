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
  private String rpid;
  private String rpName;
  private String workAddress;
  private String experience;
  private String education;
  private String salary;
  private String entName;
  private String entImg;
  private Integer state;
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createTime;
}
