package com.nettyTest.Run;

import com.nettyTest.Context.TestContextAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class RunExecute implements ApplicationRunner {
    @Autowired
    private TestContextAware contextAware;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        contextAware.initMsg();
    }
}
