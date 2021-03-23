package com.nettyTest.Test;

import com.nettyTest.Annotation.Msg;
import com.nettyTest.Bean.TestBean;
import org.springframework.stereotype.Component;

@Component
@Msg(clzz = TestBean.class)
public class TestHandler implements BaseHandler<TestBean>{
}
