package com.nettyTest.Test;

import com.nettyTest.Annotation.Msg;
import com.nettyTest.Bean.TestBean;

@Msg(clzz = TestBean.class)
public class TestHandler extends BaseHandler<TestBean>{
}
