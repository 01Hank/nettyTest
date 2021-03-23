package com.nettyTest.Test;

import com.google.protobuf.InvalidProtocolBufferException;
import com.nettyTest.Bean.BaseBean;
import com.nettyTest.Command.Data.MsgInfo;
import org.springframework.stereotype.Component;


public interface BaseHandler<T> {
    void execute(MsgInfo msgInfo) throws InvalidProtocolBufferException;
}
