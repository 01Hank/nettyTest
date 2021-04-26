package com.nettyTest.NettyClient;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class nettyClient {
    public static String host = "127.0.0.1";
    public static int port = 8081;

    public static void main(String[] args) {
        EventLoopGroup worker = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(worker);
        b.channel(NioSocketChannel.class);
        b.handler(new ClientInitializer());
        try {
            ChannelFuture f = b.connect(host, port).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {

            e.printStackTrace();
        } finally {
            worker.shutdownGracefully();
        }

    }
}
