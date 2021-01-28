package com.nettyTest.Command.HandlerPack;

import com.nettyTest.Command.AbstractHandler;
import com.nettyTest.Command.Data.MsgInfo;

/**
 * 玩家操作处理器
 */
public class PlayerDataHandler  extends AbstractHandler {
    /**
     * 消息数据
     */
    private MsgInfo msgInfo;

    public PlayerDataHandler() {
    }

    public PlayerDataHandler(MsgInfo msgInfo) {
        this.msgInfo = msgInfo;
    }

    @Override
    public void operation() {
        System.out.println("玩家正在操作其他玩家数据!!");
    }
}
