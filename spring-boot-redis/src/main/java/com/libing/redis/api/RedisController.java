package com.libing.redis.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lvlibing
 * @create 2021-08-31 23:25
 */
@RestController
public class RedisController {
    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/mm")
    public String get() {

        redisTemplate.opsForValue().set("001", "测试string");

        return "";
    }
}
