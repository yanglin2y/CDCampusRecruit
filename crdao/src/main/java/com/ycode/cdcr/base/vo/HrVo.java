package com.ycode.cdcr.base.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author YangLin
 * @createTime 2022/01/21
 */
@Data
public class HrVo implements Serializable {

  private static final long serialVersionUID = -1912906575027665755L;
  @TableId(type = IdType.AUTO)
  private Integer id;
  private String hrid;
  private String eid;
  private String entName;
  private Integer sex;
  private String mail;
  private String hrName;
  private String position;
  private String department;
  private String hrImg;
  private Integer state;
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime lastLogin;
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createTime;
}
