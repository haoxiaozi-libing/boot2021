package com.libing.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author lvlibing
 * @create 2021-08-31 23:08
 */
@SpringBootApplication
public class RedisMain {
    public static void main(String[] args) {
        SpringApplication.run(RedisMain.class, args);
    }


}
