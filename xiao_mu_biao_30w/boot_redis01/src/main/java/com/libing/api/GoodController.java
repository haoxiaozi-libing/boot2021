package com.libing.api;

import com.libing.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author lvlibing
 * @create 2021-10-02 21:26
 */
@RestController
public class GoodController {
    public static final String LOCAK_REDIS = "LOCAK_REDIS";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/buy_goods")
    public String buy_Goods() throws Exception {
        String uuid = UUID.randomUUID().toString() + Thread.currentThread().getName();
        Boolean isLocak = stringRedisTemplate.opsForValue().setIfAbsent(LOCAK_REDIS, uuid, 50, TimeUnit.SECONDS);
        if (!isLocak) {
            return "已经有线程在使用了" + serverPort;
        }
        String result = stringRedisTemplate.opsForValue().get("goods:001");// get key ====看看库存的数量够不够
        int goodsNumber = result == null ? 0 : Integer.parseInt(result);
        try {
            if (goodsNumber > 0) {
                Thread.sleep(5000);
                int realNumber = goodsNumber - 1;
                stringRedisTemplate.opsForValue().set("goods:001", String.valueOf(realNumber));
                System.out.println("成功买到商品，库存还剩下: " + realNumber + " 件" + "\t服务提供端口" + serverPort);
                return "成功买到商品，库存还剩下:" + realNumber + " 件" + "\t服务提供端口" + serverPort;
            } else {
                System.out.println("商品已经售完/活动结束/调用超时,欢迎下次光临" + "\t服务提供端口" + serverPort);
            }
        } catch (InterruptedException e) {

        } finally {
//            while (true) {
//                stringRedisTemplate.watch(LOCAK_REDIS);
//                if (uuid.equals(stringRedisTemplate.opsForValue().get(LOCAK_REDIS))) {
//                    stringRedisTemplate.setEnableTransactionSupport(true);
//                    stringRedisTemplate.multi();
//                    Boolean delete = stringRedisTemplate.delete(LOCAK_REDIS);
//                    List<Object> exec = stringRedisTemplate.exec();
//                    if (exec == null) {
//                        continue;
//                    }
//                    stringRedisTemplate.unwatch();
//                    break;
//                }
//            }
            JedisPool jedisPool = RedisUtils.getJedis();

            String script = "if redis.call('get', KEYS[1]) == ARGV[1] "
                    + "then "
                    + "    return redis.call('del', KEYS[1]) "
                    + "else "
                    + "    return 0 "
                    + "end";
            Object o = new Object();//jedisPool.eval(script, Collections.singletonList(LOCAK_REDIS), Collections.singletonList(uuid));
            if ("1".equals(o)) {
                System.out.println("解锁成功");
            } else {
                System.out.println("解锁失败");
            }
        }
        return"商品已经售完/活动结束/调用超时,欢迎下次光临"+"\t服务提供端口"+serverPort;
}

}
