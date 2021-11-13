package com.libing.自定义注解;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lvlibing
 * @create 2021-09-25 19:13
 */
public class MyLockSuport {
    public static void main(String[] args) {

        ReentrantLock lock=new ReentrantLock(true);
        lock.lock();

        AtomicInteger atomicInteger=new AtomicInteger();
        atomicInteger.getAndIncrement();
//
//        HashMap<Integer,Integer> map=new HashMap<>(10);
//        map.put(1,1);

        ThreadLocal threadLocal=new ThreadLocal();
        threadLocal.set("");



    }
}
