package com.libing;

import com.libing.redis.RedisMain;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

@SpringBootTest(classes = RedisMain.class)
public class TestDemo {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void TestMap() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(() -> {});

        Map<String, String> map = new HashMap<>();
        map.put(null, null);
        map.put("11", "11");
        map.put("22", "33");
        map.put("11", "33");
        System.out.println(map);


    }


    @Test
    void TestRedis1() {
        Map map = new HashMap<Integer, Integer>();

        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();

//        Long add = redisTemplate.boundGeoOps("geo").add(new Point(Double.valueOf("116.311707"), Double.valueOf("40.01536")), "shanghai");
//        System.out.println(add);
//        AtomicInteger a=new AtomicInteger();
//        a.getAndIncrement();

        ReferenceQueue referenceQueue = new ReferenceQueue();
        Object object = new Object();
        PhantomReference phantomReference = new PhantomReference(object, referenceQueue);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());
        object = null;
        System.gc();
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());

    }

}
