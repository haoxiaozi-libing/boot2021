package com.libing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.locks.LockSupport;

/**
 * @author lvlibing
 * @create 2021-10-02 21:24
 */
@SpringBootApplication
public class BootRedis02Application {

    public static void main(String[] args) {
        SpringApplication.run(BootRedis02Application.class,args);
    }

}
