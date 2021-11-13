package com.libing.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;

/**
 * @author lvlibing
 * @create 2021-08-31 23:08
 */
@SpringBootApplication
public class RedisMain {
    public static void main(String[] args) {
        SpringApplication.run(RedisMain.class,args);
//        Jedis jedis=new Jedis("192.168.45.110",6379);
//        String ping = jedis.ping();
//        System.out.println(ping);
//        String mset = jedis.mset("1", "1", "2", "2");
//        System.out.println(mset);
    }
}
