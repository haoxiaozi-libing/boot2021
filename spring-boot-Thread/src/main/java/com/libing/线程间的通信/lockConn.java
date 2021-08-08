package com.libing.线程间的通信;

/**
 * @author lvlibing
 * @create 2021-07-26 6:58
 */
public class lockConn {

    public static void main(String[] args) {
        Share share=new Share();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "张三").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    share.decr();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "李四").start();
    }
}


class Share {
    private int num =0;

    public synchronized void incr() throws InterruptedException {
        while (num !=0) {
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName() + "::" + num);
        this.notifyAll();
    }


    public synchronized void decr() throws InterruptedException {
        while (num !=1) {
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName() + "::" + num);
        this.notifyAll();
    }
}
