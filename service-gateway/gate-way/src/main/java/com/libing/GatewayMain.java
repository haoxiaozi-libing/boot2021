package com.libing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lvlibing
 * @create 2021-11-26 22:50
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayMain {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain.class,args);
    }
}
