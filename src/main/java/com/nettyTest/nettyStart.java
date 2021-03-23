package com.nettyTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@RestController
//@MapperScan(basePackages = "com.nettyTest.Mapper")
public class nettyStart {
    private static final Logger log = LoggerFactory.getLogger(nettyStart.class);


    public static void main(String[] args) {
        SpringApplication.run(nettyStart.class, args);
        log.info("netty测试服务器启动成功!!");
    }
}
