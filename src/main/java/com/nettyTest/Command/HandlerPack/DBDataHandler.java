package com.nettyTest.Command.HandlerPack;

import com.nettyTest.Command.AbstractHandler;

/**
 * 操作数据库
 */
public class DBDataHandler extends AbstractHandler {
    /**
     * 操作类型
     */
    private int cmdType;

    /**
     * 操作数据
     */
    private Integer data;

    /**
     * 玩家id
     */
    private int playerId;

    public DBDataHandler(int cmdType, Integer data, int playerId) {
        this.cmdType = cmdType;
        this.data = data;
        this.playerId = playerId;
    }

    @Override
    public void operation() {
        super.print("玩家操作，玩家id=" + this.playerId);
        switch (cmdType) {
            case 1:
                System.out.println("存储玩家信息：" + this.data);
                break;
            case 2:
                System.out.println("更新玩家信息：" + this.data);
                break;
            default:
                break;
        }
    }
}
