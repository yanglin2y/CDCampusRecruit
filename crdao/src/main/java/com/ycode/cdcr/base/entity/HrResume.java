package com.ycode.cdcr.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author YangLin
 * @createTime 2022/02/07
 */
@TableName("hr_resume")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class HrResume implements Serializable {

  private static final long serialVersionUID = -2671284873573528952L;
  @TableId(type = IdType.AUTO)
  private Integer id;
  private String uid;
  private Integer rpid;
  private String rpName;
  private String apName;
  private String education;
  private Integer state;
  private String hrid;
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createTime;
}
