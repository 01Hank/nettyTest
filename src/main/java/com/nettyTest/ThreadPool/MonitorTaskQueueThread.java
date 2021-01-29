package com.nettyTest.ThreadPool;


import com.nettyTest.Command.Command;
import com.nettyTest.Command.CommandImpl.DBCommandImpl;
import com.nettyTest.Command.CommandImpl.PlayerCommandImpl;
import com.nettyTest.Command.Data.MsgInfo;
import com.nettyTest.Command.HandlerPack.PlayerDataHandler;
import com.nettyTest.Command.PackClass;
import com.nettyTest.Command.PackObject;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 监听任务队列线程
 */
public class MonitorTaskQueueThread extends Thread {
    /**
     * 如果没有任务线程会休眠时间
     */
    private long sleepTime;

    /**
     * 休眠时间超过这个值会直接关闭线程
     */
    private long shotDowTime;

    /**
     * 任务队列
     */
    private LinkedBlockingQueue<MsgInfo> msgQueue = new LinkedBlockingQueue<>();


    /**
     * 已经休眠时间
     */
    private long alreadSleepTime;

    /**
     * DB操作命令
     */
    private Command dbCommand = new DBCommandImpl();

    /**
     * 玩家操作命令
     */
    private Command playerCommand = new PlayerCommandImpl();

    /**
     * 构建一个打包器
     */
    private PackClass packClass = new PackClass();

    /**
     * 构建一个打包对象
     */
    private PackObject packObject = new PackObject();


    /**
     * 私有空构造函数
     */
    private MonitorTaskQueueThread() {
    }

    /**
     * 构造函数
     *
     * @param name        线程名称
     * @param sleepTime   空队列是休眠时间
     * @param shotDowTime 休眠时间超过则关闭
     */
    public MonitorTaskQueueThread(String name, long sleepTime, long shotDowTime) {
        super(name);
        this.sleepTime = sleepTime;
        this.shotDowTime = shotDowTime;
    }

    @Override
    public void run() {
        super.run();

        //是否终止执行监听
        boolean isStop = false;
        try {
            do {
                //查看任务队列是否有待处理的任务
                if (this.msgQueue.isEmpty()) {
                    if (this.alreadSleepTime >= this.shotDowTime) {
                        //关闭线程
                        System.out.println("执行关闭线程");
                        interrupt();
                        isStop = true;
                    } else {
                        Thread.sleep(this.sleepTime);
                        this.alreadSleepTime += this.sleepTime;
                        System.out.println("开始休眠");
                    }
                } else {
                    //清除已睡眠时间
                    this.alreadSleepTime = 0L;
                    System.out.println("处理任务,任务队列长度：" + this.msgQueue.size());
                    MsgInfo poll = this.msgQueue.poll();
                    System.out.println("已处理一个消息，消息类型：" + poll.getType());

                    //处理任务
                    if (poll.getType() == 1) {
                        //玩家操作
                        PlayerDataHandler playerDataHandler = new PlayerDataHandler(poll);
                        packObject.setCommand(this.playerCommand);
                        packObject.setHandler(playerDataHandler);
                        packClass.setPackObject(packObject);
                        packClass.startPack();

                        //去除打包好的命令
                        playerCommand = packClass.getCommand();

                        //放到玩家线程池处理
                        playerCommand.action();
                    }

                }
            } while (!isStop);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 添加处理任务
     *
     * @return
     */
    public boolean addMsg(MsgInfo msg) {
        boolean isSuc = false;
        try {
            isSuc = this.msgQueue.add(msg);
            System.out.println("添加待处理任务");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuc;
    }
}
