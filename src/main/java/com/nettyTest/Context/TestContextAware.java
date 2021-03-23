package com.nettyTest.Context;

import com.nettyTest.Annotation.Msg;
import com.nettyTest.Test.BaseHandler;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TestContextAware implements ApplicationContextAware {
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
            if(handler.getClass().isAnnotationPresent(Msg.class)){
                factory.put(handler.getClass().getSimpleName(),handler.getClass());
            }
        }
    }
}
