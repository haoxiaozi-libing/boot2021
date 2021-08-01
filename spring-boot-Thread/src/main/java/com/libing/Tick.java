package com.libing;

/**
 * @author lvlibing
 * @create 2021-07-25 17:14
 */
public class Tick implements Runnable {
    private int tick=100;

    @Override
    public void run() {
        while (true){
            if(tick==0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->拿到了"+tick--);
        }
    }

    public static void main(String[] args) {
        Tick ti=new Tick();
        new Thread(ti,"小明").start();
        new Thread(ti,"老师").start();
        new Thread(ti,"黄牛").start();
    }
}
