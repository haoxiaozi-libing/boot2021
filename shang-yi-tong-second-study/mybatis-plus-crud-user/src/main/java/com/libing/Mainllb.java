package com.libing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lvlibing
 * @create 2021-12-18 22:54
 */
@EnableDiscoveryClient
@MapperScan(value = "com.libing.mapper")
@SpringBootApplication
public class Mainllb {
    public static void main(String[] args) {
        SpringApplication.run(Mainllb.class, args);
    }
}
