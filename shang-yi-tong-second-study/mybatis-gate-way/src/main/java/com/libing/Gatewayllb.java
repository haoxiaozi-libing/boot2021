package com.libing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lvlibing
 * @create 2021-12-19 13:51
 */

@EnableDiscoveryClient
@ComponentScan(basePackages = "com.libing")
@SpringBootApplication
public class Gatewayllb {
    public static void main(String[] args) {
        SpringApplication.run(Gatewayllb.class, args);
    }
}
