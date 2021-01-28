package com.nettyTest.Command.HandlerPack;

import com.nettyTest.Command.AbstractHandler;

/**
 * 玩家操作处理器
 */
public class PlayerDataHandler  extends AbstractHandler {
    @Override
    public void operation() {
        System.out.println("玩家正在操作其他玩家数据!!");
    }
}
