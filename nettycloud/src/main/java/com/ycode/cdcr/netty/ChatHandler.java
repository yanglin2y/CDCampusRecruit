package com.ycode.cdcr.netty;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ycode.cdcr.common.redis.MyRedisOperate;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import java.util.Objects;

/**
 * @author YangLin
 * @createTime 2022/02/08
 */
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
  private static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

  @Override
  protected void channelRead0(ChannelHandlerContext ctx,
      TextWebSocketFrame textWebSocketFrame) throws Exception {
    //获取客户端消息
    String content = textWebSocketFrame.text();
    if (content!=null){
      JSONObject jsonObject = JSON.parseObject(content);
      //获取到发送人的用户id
      Integer state = (Integer) jsonObject.get("state");
      String senderId = (String) jsonObject.get("senderId");
      String receiverId = (String) jsonObject.get("receiverId");
      Channel channel = ctx.channel();
      if (state.equals(0)) {
        //说明是第一次登录上来连接，还没有开始进行聊天，将uid加到map里面
        register(senderId,receiverId, channel);
      } else {
        //有消息了,开始聊天了
        sendMsg(content,senderId, receiverId);
//        sendMsg2(content,channel);
      }
    }
    // wo ni
  }
  private void sendMsg(String content,String senderId,String receiverId) {
    MyRedisOperate myRedisOperate = (MyRedisOperate) SpringUtils.getBean("myRedisOperate");
    Channel channel = ChatConfig.concurrentHashMap.get(receiverId+"_"+senderId);
    String key = receiverId+"_"+senderId;

    if (!Objects.isNull(channel) &&channel.isActive() ) {
      channel.writeAndFlush(new TextWebSocketFrame(content));
    }else {
      if (myRedisOperate.keyExists(key)){
        String s =myRedisOperate.get(key);
        String data = s+"&&&&"+content;
        myRedisOperate.set(key,data);
      }else{
        myRedisOperate.set(key,content);
      }
    }
  }
  private void register(String senderId,String receiverId,Channel channel) {
    MyRedisOperate myRedisOperate = (MyRedisOperate) SpringUtils.getBean("myRedisOperate");
      ChatConfig.concurrentHashMap.put(senderId+"_"+receiverId, channel);
    String key =senderId+"_"+receiverId;
    if (myRedisOperate.keyExists(key)){
      String s = myRedisOperate.get(key);
      String[] split = s.split("&&&&");
      for (String s1 : split) {
        channel.writeAndFlush(new TextWebSocketFrame(s1));
        System.out.println(s1);
      }
      myRedisOperate.delKey(key);
    }

  }
  @Override
  public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
    System.out.println("有用户连接");
    clients.add(ctx.channel());
  }

  @Override
  public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
    System.out.println("有用户断开");
    clients.remove(ctx.channel());
  }

}
