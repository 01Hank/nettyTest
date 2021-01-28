package com.nettyTest.Command.CommandImpl;

import com.nettyTest.Command.AbstractCommand;

/**
 * 操作DB的命令
 */
public class DBCommandImpl extends AbstractCommand {

    @Override
    public void action() {
        //启动命令
        super.getHandler().operation();

        //这里可以刷新玩家的数据
        System.out.println("一个DB命令执行完成");
    }

    @Override
    public void revoke() {

    }
}
