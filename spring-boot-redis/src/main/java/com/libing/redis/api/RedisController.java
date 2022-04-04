package com.libing.redis.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.geo.Point;
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
    public void get() {
        redisTemplate.opsForValue().set("hahah","dddd");
        System.out.println(redisTemplate.opsForValue().get("hahah"));
//        redisTemplate.opsForGeo().add("citys", new Point(11111, 11111), "beijing");
//        redisTemplate.opsForGeo().add("citys", new Point(11112, 11112), "beijing");
//        redisTemplate.opsForGeo().add("citys", new Point(11113, 11113), "beijing");
    }
}
