package com.ycode.cdcr.entcloud.entity.po;

/**
 * @author YangLin
 * @createTime 2022/01/12
 */

import java.io.Serializable;
import lombok.Data;

@Data
public class Token implements Serializable {


  private static final long serialVersionUID = -7128816834948063894L;

  private String token;

  private Long loginTime;
  public Token(String token,Long loginTime){
    super();
    this.token = token;
    this.loginTime = loginTime;
  }
}
