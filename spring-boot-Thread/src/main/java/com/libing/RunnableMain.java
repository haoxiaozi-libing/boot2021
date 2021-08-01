package com.libing;

/**
 * @author lvlibing
 * @create 2021-07-25 17:03
 */
public class RunnableMain implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("学习--->" + i);
        }
    }


    public static void main(String[] args) {
        RunnableMain runnableMain = new RunnableMain();
        new Thread(runnableMain).start();
        for (int i = 0; i < 20; i++) {
            System.out.println("看书--》"+i);
        }
    }
}
