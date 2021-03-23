package com.nettyTest.NettyServer.Handler;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import com.nettyTest.Command.Data.MsgInfo;
import com.nettyTest.Context.TestContextAware;
import com.nettyTest.ProtoFile.Msg;
import com.nettyTest.Test.BaseHandler;
import com.nettyTest.ThreadPool.DisMonitorTaskServer;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

public class ServerHandler extends SimpleChannelInboundHandler<Message> {

    /**
     * 任务线程分发服务
     */
    private DisMonitorTaskServer server = null;


    /**
     * 覆盖 channelActive 方法 在channel被启用的时候触发 (在建立连接的时候)
     *
     * @param ctx
     * @throws Exception
     */
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("RamoteAddress : " + ctx.channel().remoteAddress() + " active !");
        String welcome = "Welcome to " + InetAddress.getLocalHost().getHostName() + " service!";
        Msg.Server response = Msg.Server.newBuilder().setCode(101).setMessage(welcome).build();
        ctx.writeAndFlush(response);
        super.channelActive(ctx);
    }

    /**
     * 处理客户端发送的消息
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        if (this.server == null) {
            this.server = new DisMonitorTaskServer(10, "玩家监听", 2000L, 10000L);
        }

        //包装消息
        MsgInfo msgInfo = new MsgInfo();
        msgInfo.setType(1);
        msgInfo.setMessage(msg);
        msgInfo.setPlayerId(12345);
        msgInfo.setCtx(ctx);
//        this.server.putMsg(msgInfo, 1);
        //创建handler
        String simpleName = msg.getClass().getSimpleName();
        BaseHandler handler = TestContextAware.createHandler(simpleName);
        handler.execute(msgInfo);
    }
}
