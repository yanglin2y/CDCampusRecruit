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
 * @createTime 2022/02/09
 */
@TableName("ap_relation")
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class ApRelation implements Serializable {

  private static final long serialVersionUID = -7647911145287906958L;
  @TableId(type = IdType.AUTO)
  private Integer id;
  private String uid;
  private String hrid;
  private String hrName;
  private String hrImg;
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createTime;

}
