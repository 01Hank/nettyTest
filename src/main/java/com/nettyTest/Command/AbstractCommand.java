package com.nettyTest.Command;


/**
 * 命令处理器提供命令
 */
public abstract class AbstractCommand implements Command {
    /**
     * 待操作事件
     */
    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void setDoHandler(Handler handler) {
        this.setHandler(handler);
    }
}
