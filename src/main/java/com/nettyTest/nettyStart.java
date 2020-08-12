package com.nettyTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@RestController
@MapperScan(basePackages = "com.nettyTest.Mapper")
public class nettyStart {
    public static void main(String[] args) {
        SpringApplication.run(nettyStart.class,args);
    }
}
