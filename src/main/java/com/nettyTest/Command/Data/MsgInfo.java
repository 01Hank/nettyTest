package com.nettyTest.Command.Data;

import com.google.protobuf.Message;
import io.netty.channel.ChannelHandlerContext;

/**
 * 协议数据
 */
public class MsgInfo {
    /**
     * 数据操作类型
     */
    private int type;

    /**
     * 通道id
     */
    private int channle;

    /**
     * 玩家id
     */
    private int playerId;

    /**
     * 消息
     */
    private Message message;

    /**
     * netty信息
     */
    private ChannelHandlerContext ctx;

    public int getChannle() {
        return channle;
    }

    public void setChannle(int channle) {
        this.channle = channle;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ChannelHandlerContext getCtx() {
        return ctx;
    }

    public void setCtx(ChannelHandlerContext ctx) {
        this.ctx = ctx;
    }
}
