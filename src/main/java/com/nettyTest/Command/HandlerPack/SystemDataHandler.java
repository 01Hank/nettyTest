package com.nettyTest.Command.HandlerPack;


import com.nettyTest.Command.AbstractHandler;

/**
 * 系统操作处理器
 */
public class SystemDataHandler extends AbstractHandler {
    @Override
    public void operation() {
        System.out.println("系统正在操作!!!");
    }
}
