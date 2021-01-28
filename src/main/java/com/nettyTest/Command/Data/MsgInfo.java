package com.nettyTest.Command.Data;

import com.google.protobuf.Message;

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
    private Object message;

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

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
