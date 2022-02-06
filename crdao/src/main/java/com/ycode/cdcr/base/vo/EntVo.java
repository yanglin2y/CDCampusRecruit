package com.ycode.cdcr.base.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author YangLin
 * @createTime 2022/01/25
 */
@Data
public class EntVo implements Serializable {


  private static final long serialVersionUID = 980279536732829120L;
  @TableId(type = IdType.AUTO)
  private Integer id;
  private String eid;
  private String entName;
  private String companyIntroduction;
  private String productIntroduction;
  private String employeesNum;
  private String enterpriseLabel;
  private String address;
  private String entImg;
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createTime;

}
