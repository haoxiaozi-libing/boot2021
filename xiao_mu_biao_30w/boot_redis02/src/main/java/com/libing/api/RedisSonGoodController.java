package com.libing.api;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author lvlibing
 * @create 2021-10-02 21:26
 */
@RestController
public class RedisSonGoodController {

    public static final String LOCAK_REDIS = "LOCAK_REDIS";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    Redisson redisson;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/buy_goods")
    public String buy_Goods() throws InterruptedException {
        RLock lock = redisson.getLock(LOCAK_REDIS);
        lock.lock();
        String result = stringRedisTemplate.opsForValue().get("goods:001");// get key ====看看库存的数量够不够
        int goodsNumber = result == null ? 0 : Integer.parseInt(result);
        try {
            new HashMap<>().put("","");
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
            if(lock.isLocked()&&lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
        return "商品已经售完/活动结束/调用超时,欢迎下次光临" + "\t服务提供端口" + serverPort;
    }

}
