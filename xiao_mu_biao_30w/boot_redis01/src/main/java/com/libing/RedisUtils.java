package com.libing;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author lvlibing
 * @create 2021-10-03 11:05
 */
public class RedisUtils {

    private  static JedisPool jedisPool;

    static {
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxIdle(10);
        jedisPool=new JedisPool(jedisPoolConfig);
    }

    public static JedisPool getJedis() throws Exception{
        if(jedisPool == null)
            throw new NullPointerException("JedisPool is not OK.");
        return jedisPool;
    }
}
