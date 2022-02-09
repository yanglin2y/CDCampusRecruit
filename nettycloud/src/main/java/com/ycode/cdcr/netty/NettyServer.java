package com.ycode.cdcr.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author YangLin
 * @createTime 2022/02/08
 */
public class NettyServer {
  private final int port = 7888;

  public void start() throws Exception {
    EventLoopGroup bossGroup = new NioEventLoopGroup();

    EventLoopGroup group = new NioEventLoopGroup();
    try {
      ServerBootstrap sb = new ServerBootstrap();
      // 绑定线程池
      sb.group(group, bossGroup)
          // 指定使用的channel
          .channel(NioServerSocketChannel.class)
          // 绑定监听端口
          .localAddress(this.port)
          // 绑定客户端连接时候触发操作
          .childHandler(new NettyServerInitializer());
      // 服务器异步创建绑定
      ChannelFuture cf = sb.bind(this.port).sync();
      System.out.println(NettyServer.class + " 启动正在监听： " + cf.channel().localAddress());
      // 关闭服务器通道
      cf.channel().closeFuture().sync();
    } finally {
      // 释放线程池资源
      group.shutdownGracefully().sync();
      bossGroup.shutdownGracefully().sync();
    }
  }
}

