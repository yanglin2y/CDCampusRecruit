package com.ycode.cdcr.netty;

import java.io.Serializable;
import lombok.Data;

/**
 * @author YangLin
 * @createTime 2022/02/09w
 */
@Data
public class ChatMsg implements Serializable {
  private String senderId;
  private String receiverId;
  private String msg;

}
