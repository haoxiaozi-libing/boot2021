package com.libing.自定义注解.park;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lvlibing
 * @create 2021-10-01 12:15
 */
public class MySelfLockSupport {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        Thread a = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + "coming in...");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "11out in...");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "111out in...");
        }, "线程A");
        a.start();

        Thread b = new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + "coming in...");
            LockSupport.unpark(a);
        }, "线程b");
        b.start();

    }
}
