package com.libing;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author lvlibing
 * @create 2021-08-30 22:42
 */
public class MyTick implements Runnable {

    private int num=100;
    private static Object object=new Object();

    @Override
    public void run() {
        while (true){
            synchronized (object) {
                if(num>=0){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {

                    }
                    System.out.println(Thread.currentThread().getName()+"开始跑了。。。"+num--);
                }
            }
        }
    }

    public static void main(String[] args) {
        MyTick myTick=new MyTick();
        Thread thread1=new Thread(myTick,"线程一");
        Thread thread2=new Thread(myTick,"线程二");
        thread1.start();
        thread2.start();

    }
}
