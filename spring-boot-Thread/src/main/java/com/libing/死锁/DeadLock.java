package com.libing.死锁;

import java.beans.Transient;

/**
 * @author lvlibing
 * @create 2021-09-11 8:37
 */
public class DeadLock implements Runnable {
    String lockA = "lockA";
    String lockB = "lockB";

    public DeadLock() {
    }

    public DeadLock(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaa");
            synchronized (lockB) {
                System.out.println("请求b....................");
            }
        }

        synchronized (lockB) {
            System.out.println("bbbbbbbbbbbbbbbbbbbbbbbb");
            synchronized (lockA) {
                System.out.println("请求a....................");
            }
        }

    }
}

class TreadMain {

    String lockA = "lockA";
    String lockB = "lockB";

    public static void main(String[] args) {
        Thread thread = new Thread(new DeadLock());
        thread.start();
        thread.start();
    }
    public static void maina(String[] args) {



        TreadMain treadMain = new TreadMain();
        ClassLoader parent = treadMain.getClass().getClassLoader();
        ClassLoader parensst = treadMain.getClass().getClassLoader().getParent();
        ClassLoader parenssssst = treadMain.getClass().getClassLoader().getParent().getParent();


        Object object = new Object();
        ClassLoader classLoader = object.getClass().getClassLoader();
        ClassLoader classsLoader = object.getClass().getClassLoader().getParent();


//        ClassLoader classLoader = TreadMain.class.getClassLoader();
//        Class<?>[] interfaces = TreadMain.class.getInterfaces();
//        System.out.println(classLoader+""+interfaces);

//        new Thread(new DeadLock("lockA","lockB"),"线程一").start();
//        new Thread(new DeadLock("lockB","lockA"),"线程二").start();
    }
}
