package com.nettyTest.Command.CommandImpl;

import com.nettyTest.Command.AbstractCommand;


/**
 * 玩家命令类
 */
public class PlayerCommandImpl extends AbstractCommand {
    @Override
    public void action() {
        //执行操作
        super.getHandler().operation();
        System.out.println("一个玩家操作执行完成!!!");
    }

    @Override
    public void revoke() {

    }
}
