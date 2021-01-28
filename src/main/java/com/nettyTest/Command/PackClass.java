package com.nettyTest.Command;

/**
 * 打包handler
 */
public class PackClass {
    /**
     * 打包对象
     */
   private PackObject packObject;



    public void setPackObject(PackObject packObject) {
        this.packObject = packObject;
    }

    /**
     * 开始打包
     *
     * @return
     */
    public void startPack() {
        //打包命令
        this.packCommand();
    }



    /**
     * 打包命令
     *
     * @return
     */
    private void packCommand() {
        this.packObject.getCommand().setDoHandler(this.packObject.getHandler());
    }

    /**
     * 返回打包好的命令
     *
     * @return
     */
    public Command getCommand() {
        return this.packObject.getCommand();
    }
}
