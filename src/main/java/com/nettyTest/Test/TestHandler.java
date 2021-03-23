package com.nettyTest.Test;

import com.google.protobuf.InvalidProtocolBufferException;
import com.nettyTest.Annotation.MsgHandler;
import com.nettyTest.Bean.TestBean;
import com.nettyTest.Command.Data.MsgInfo;
import com.nettyTest.ProtoFile.Msg;
import org.springframework.stereotype.Component;

@Component
@MsgHandler(clzz = Msg.Client.class)
public class TestHandler implements BaseHandler<Msg.Client>{

    @Override
    public void execute(MsgInfo msgInfo) throws InvalidProtocolBufferException {
        Msg.Client req = Msg.Client.parseFrom(msgInfo.getMessage().toByteArray());
        System.out.println("收到客户端消息：" + req.getBody());
    }
}
