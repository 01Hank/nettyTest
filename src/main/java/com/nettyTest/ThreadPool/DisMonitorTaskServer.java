package com.nettyTest.ThreadPool;

import com.nettyTest.Command.Data.MsgInfo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 分发任务类
 */
public class DisMonitorTaskServer {
    /**
     * 线程最大持有个数
     */
    private int MaxThreadNum = 10;

    /**
     * 处理消息名
     */
    private String disName = "Dis";

    /**
     * 休眠时间
     */
    private long sleepTime;

    /**
     * 关闭时间
     */
    private long shotDowTime;


    /**
     * 线程持有数据，key=线程id，value=持有的唯一id
     */
    private Map<Integer, List<Integer>> useRuleMap = new HashMap<>();

    /**
     * 所有消息线程监听队列,key=线程id，value=监听线程
     */
    private Map<Integer, MonitorTaskQueueThread> threadMap = new ConcurrentHashMap<>();

    /**
     * 线程id，递增
     */
    private int threadId = 1;


    public DisMonitorTaskServer(int maxThreadNum, String disName, long sleepTime, long shotDowTime) {
        MaxThreadNum = maxThreadNum;
        this.disName = disName;
        this.sleepTime = sleepTime;
        this.shotDowTime = shotDowTime;
    }

    /**
     * 私有空构造
     */
    private DisMonitorTaskServer() {
    }

    /**
     * 放入消息
     *
     * @param msg
     * @param Uid
     * @return
     */
    public boolean putMsg(MsgInfo msg, int Uid) throws Exception {
        //检查应该放在那个监听线程
        int threadId = checkRuleMap(Uid);
        MonitorTaskQueueThread queueThread = null;
        if (threadId == -1) {
            //还没有线程监听，创建新的线程监听
            queueThread = new MonitorTaskQueueThread(this.disName, this.sleepTime, this.shotDowTime);
            queueThread.start();
            this.threadMap.put(this.threadId + 1, queueThread);
        } else {
            queueThread = this.threadMap.get(threadId);
        }


        if (queueThread != null) {
            //放入消息
            return queueThread.addMsg(msg);
        } else {
            return false;
        }
    }


    /**
     * 检查UID所持有的的线程id
     *
     * @param Uid
     * @return
     */
    private int checkRuleMap(int Uid) {
        int threadId = -1;
        Set<Integer> keySet = this.useRuleMap.keySet();
        for (Integer key : keySet) {
            if (this.useRuleMap.get(key).contains(Uid)) {
                threadId = key;
                return threadId;
            }
        }

        return threadId;
    }


}
