package com.libing.自定义注解.aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lvlibing
 * @create 2021-10-07 13:59
 */
public class AqstThread {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();

    }
}
