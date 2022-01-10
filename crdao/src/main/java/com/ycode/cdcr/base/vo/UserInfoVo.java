package com.ycode.cdcr.base.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

/**
 * @author YangLin
 * @createTime 2022/01/19
 */
@Data
public class UserInfoVo  implements Serializable {

  private static final long serialVersionUID = -2035437769386912928L;
  private Integer id;
  private String uid;
  private String apName;
  private String account;
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  private LocalDate birthday;
  private Integer sex;
  private String city;
  private String iphone;
  private String mail;
  private String apImg;
}
