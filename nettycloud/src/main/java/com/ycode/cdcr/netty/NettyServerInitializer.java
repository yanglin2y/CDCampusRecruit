package com.ycode.cdcr.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author YangLin
 * @createTime 2022/02/08
 */

public class NettyServerInitializer extends ChannelInitializer<NioSocketChannel> {

  @Override
  protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
    //获得对应的管道
    ChannelPipeline pipeline = nioSocketChannel.pipeline();
    //就是一个HTTP解码器
    pipeline.addLast("HttpServerCodec",new HttpServerCodec());

    pipeline.addLast("",new ChunkedWriteHandler());
    pipeline.addLast(new HttpObjectAggregator(1024*64));
    pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
    pipeline.addLast(new ChatHandler());

  }
}
