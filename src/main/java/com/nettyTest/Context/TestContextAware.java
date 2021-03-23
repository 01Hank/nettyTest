package com.nettyTest.Context;

import com.nettyTest.Annotation.Msg;
import com.nettyTest.Test.BaseHandler;
import com.nettyTest.Test.TestHandler;
import com.nettyTest.nettyStart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TestContextAware implements ApplicationContextAware {
    private static final Logger log = LoggerFactory.getLogger(TestContextAware.class);

    private static ApplicationContext context = null;

    private static Map<String,Class> factory = new HashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    /**
     * 初始化工厂
     */
    public void initMsg(){
        Map<String, BaseHandler> beansOfType = context.getBeansOfType(BaseHandler.class);
        for(BaseHandler handler:beansOfType.values()){
            Class<? extends BaseHandler> aClass = handler.getClass();
            Msg msg = aClass.getAnnotation(Msg.class);
            if(msg != null){
                String simpleName = msg.clzz().getSimpleName();
                factory.put(simpleName,aClass);
            }
        }

        log.info("handler工厂初始化完成");
    }
}
