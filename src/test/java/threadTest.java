import com.nettyTest.Command.Data.MsgInfo;
import com.nettyTest.ThreadPool.MonitorTaskQueueThread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 线程测试类
 */
public class threadTest {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(4, 3);

        List<Integer> arr = map.keySet().stream().collect(Collectors.toList());
        System.out.println(arr.toString());
//        MonitorTaskQueueThread thread = new MonitorTaskQueueThread("测试线程", 2000L, 10000L);
//
//        thread.start();
//
//        try {
//            //主线程睡眠4秒后添加任务
//            Thread.sleep(4000L);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("主线程开始添加任务!!");
//        MsgInfo msgInfo = new MsgInfo();
//        msgInfo.setType(1);
//        thread.addMsg(msgInfo);
    }
}
