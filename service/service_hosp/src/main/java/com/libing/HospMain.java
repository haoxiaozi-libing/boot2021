package com.libing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author lvlibing
 * @create 2021-08-08 14:44
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.libing")
public class HospMain {
    public static void main(String[] args) {
        SpringApplication.run(HospMain.class,args);
    }
}
