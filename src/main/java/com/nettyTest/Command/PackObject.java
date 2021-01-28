package com.nettyTest.Command;


/**
 * 打包对象
 */
public class PackObject {
    /**
     * 要打包的处理器
     */
    private Handler handler;

    /**
     * 要包装的命令类
     */
    private Command command;


    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
