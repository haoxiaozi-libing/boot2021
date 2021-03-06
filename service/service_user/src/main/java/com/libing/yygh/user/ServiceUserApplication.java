package com.libing.yygh.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lvlibing
 * @create 2021-11-29 7:47
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.libing")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.libing")
public class ServiceUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceUserApplication.class, args);
    }
}