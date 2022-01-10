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
 * 在招职位表
 */
@Data
@TableName("recruitment_position")
@Builder
@EqualsAndHashCode(callSuper = false)
public class RecruitmentPosition implements Serializable {

  private static final long serialVersionUID = 8093522889340138727L;
  @TableId(type = IdType.AUTO)
  private Integer rpid;
  private Long hrid;
  private Long eid;
  private String rpName;
  private String salary;
  private String workAddress;
  private String experience;
  private String positionLabel;
  private String jobResponsibilities;
  private String additionalInformation;
  private LocalDate createTime;

}
