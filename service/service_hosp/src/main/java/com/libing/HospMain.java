package com.libing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

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
