package com.libing.自定义注解.list;

import org.w3c.dom.ranges.Range;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lvlibing
 * @create 2021-09-30 20:00
 */
public class ArrayLlistDemo {
    public static void main(String[] args) throws InterruptedException {
        List<String> list= new CopyOnWriteArrayList();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(Math.random()+"");
                System.out.println(list);
            }).start();
        }

        Lock lock=new ReentrantLock();
        lock.lock();

        LockSupport.park(new Thread());

    }
}
