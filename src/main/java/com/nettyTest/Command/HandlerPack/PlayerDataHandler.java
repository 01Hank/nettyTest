package com.nettyTest.Command.HandlerPack;

import com.google.protobuf.Message;
import com.nettyTest.Command.AbstractHandler;
import com.nettyTest.Command.Data.MsgInfo;
import com.nettyTest.ProtoFile.Msg;
import io.netty.channel.ChannelHandlerContext;

/**
 * 玩家操作处理器
 */
public class PlayerDataHandler extends AbstractHandler {
    /**
     * 消息数据
     */
    private MsgInfo msgInfo;

    private PlayerDataHandler() {
    }

    public PlayerDataHandler(MsgInfo msgInfo) {
        this.msgInfo = msgInfo;
    }

    @Override
    public void operation() {
        ChannelHandlerContext ctx = msgInfo.getCtx();
        Message msg = (Message)msgInfo.getMessage();

        Msg.Server response = null;
        if (msg instanceof Msg.Client) {
            Msg.Client clientMsg = (Msg.Client) msg;
            System.out.println(ctx.channel().remoteAddress() + " Say : " + clientMsg.getBody());
            response = Msg.Server.newBuilder().setCode(0).setMessage("Received client message success").build();
        } else {
            response = Msg.Server.newBuilder().setCode(-1).setMessage("client message is illegal").build();
            System.out.println("client message is illegal");
        }
        // 返回客户端消息 - 我已经接收到了你的消息
        ctx.writeAndFlush(response);
    }
}
