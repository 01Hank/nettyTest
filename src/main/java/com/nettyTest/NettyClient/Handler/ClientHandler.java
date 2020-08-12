package com.nettyTest.NettyClient.Handler;

import com.google.protobuf.Message;
import com.nettyTest.ProtoFile.Msg;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ClientHandler extends SimpleChannelInboundHandler<Message> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Message msg) throws Exception {
        System.out.println("Server say : " + msg.toString());
    }

    /**
     *
     */
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client active ");
        Msg.Client msg = Msg.Client.newBuilder().setHead("Content-Type:application/json;charset=UTF-8").setBody("hello world!").build();
        ctx.writeAndFlush(msg);
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client close ");
        super.channelInactive(ctx);
    }

}
