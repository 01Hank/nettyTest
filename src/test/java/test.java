import com.nettyTest.Command.Command;
import com.nettyTest.Command.CommandImpl.DBCommandImpl;
import com.nettyTest.Command.CommandImpl.PlayerCommandImpl;
import com.nettyTest.Command.Data.MsgInfo;
import com.nettyTest.Command.Handler;
import com.nettyTest.Command.HandlerPack.DBDataHandler;
import com.nettyTest.Command.HandlerPack.PlayerDataHandler;
import com.nettyTest.Command.PackClass;
import com.nettyTest.Command.PackObject;

import java.util.ArrayList;
import java.util.List;


public class test {
    public static void main(String[] args) {

        List<Command> commandList = new ArrayList<>();
        //构建一个打包器
        PackClass packClass = new PackClass();
        //构建一个打包对象
        PackObject packObject = new PackObject();
        //开始打包
        Handler handler = new DBDataHandler(1, 1, 123);
        Command command = new DBCommandImpl();
        packObject.setCommand(command);
        packObject.setHandler(handler);
        packClass.setPackObject(packObject);
        packClass.startPack();
        //打包完成获取命令
        command = packClass.getCommand();


        //加入命令队列
        commandList.add(command);

        //打包第二个命令
        handler = new PlayerDataHandler(new MsgInfo());

        command = new PlayerCommandImpl();

        packObject.setCommand(command);
        packObject.setHandler(handler);
        packClass.setPackObject(packObject);
        packClass.startPack();
        //加入命令队列
        commandList.add(command);

        //执行命令
        for(int i=0,len=commandList.size();i<len;i++){
            //执行命令
            commandList.get(i).action();
        }
    }
}
