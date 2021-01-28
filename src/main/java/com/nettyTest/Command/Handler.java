package com.nettyTest.Command;

/**
 * 所有待处理的事件父接口
 */
public interface Handler {
    /**
     * 执行操作
     */
    void operation();

}