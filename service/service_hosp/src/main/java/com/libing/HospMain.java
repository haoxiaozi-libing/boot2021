package com.libing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lvlibing
 * @create 2021-08-08 14:44
 */
@SpringBootApplication
@MapperScan("com.libing.mapper")
public class HospMain {
    public static void main(String[] args) {
        SpringApplication.run(HospMain.class,args);
    }
}
