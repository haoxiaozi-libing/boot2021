package com.libing.cmn.api;

import com.libing.cmn.ServiceCmnApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lvlibing
 * @create 2021-08-22 22:16
 */
@SpringBootTest(classes = ServiceCmnApplication.class)
@RunWith(Runner.class)
class CmnApiTest {

    @Autowired
    RedisTemplate redisTemplate;
    @Test
    void getUser() {
        Object lvlibing = redisTemplate.opsForValue().get("lvlibing");
    }
}