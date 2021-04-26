package com.nettyTest.Command;

import java.util.HashMap;
import java.util.Map;


/**
 * 处理器储存需要处理的数据
 */
public abstract class AbstractHandler implements Handler {

    //可以统一做一些公用操作
    public void print(String name) {
        System.out.println("这是一个" + name);
    }
}
