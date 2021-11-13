package com.libing;

import java.util.concurrent.*;

/**
 * @author lvlibing
 * @create 2021-09-10 20:22
 */

public class ThreadFaceMain {

    public static void main(String[] args) {
//        Throwable
//        BlockingQueue blockingQueue=new ArrayBlockingQueue(3);
//        System.out.println(blockingQueue.add(1));
//        System.out.println(blockingQueue.add(1));
//        System.out.println(blockingQueue.add(1));
//        System.out.println(blockingQueue.remove(1));
//        System.out.println(blockingQueue.remove(1));
//        System.out.println(blockingQueue.remove(1));
//        System.out.println(blockingQueue.remove(1));
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newCachedThreadPool();

        ExecutorService executorService3=new ThreadPoolExecutor(2,5,1l,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>(3),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
    }

}
