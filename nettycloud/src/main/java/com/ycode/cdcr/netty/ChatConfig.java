package com.ycode.cdcr.netty;

import io.netty.channel.Channel;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author YangLin
 * @createTime 2022/02/09
 */
public class ChatConfig {
  public static ConcurrentHashMap<String, Channel> concurrentHashMap = new ConcurrentHashMap();


}
