package com.nettyTest.Command;

/**
 * 所有命令父接口
 */
public interface Command {
    /**
     * 执行命令
     */
    void action();

    /**
     * 撤销命令
     */
    void revoke();

    /**
     * 放入处理器
     * @param handler
     */
    void setDoHandler(Handler handler);
}
