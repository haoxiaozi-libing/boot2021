package com.libing;

/**
 * @author lvlibing
 * @create 2021-07-25 16:17
 */
public class ThreadMain extends Thread {
    // 集成thread类 重写run方法,调用start方法开始执行多线程
    @Override
    public void run() {
        for (int i = 0; i <20; i++) {
            System.out.println("i:---->"+i);
        }
    }

    public static void main(String[] args) {
        ThreadMain threadMain=new ThreadMain();
        threadMain.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("主线程：---》"+i);
        }
    }
}
