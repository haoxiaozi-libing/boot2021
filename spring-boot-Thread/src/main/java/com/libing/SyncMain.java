package com.libing;

import lombok.extern.slf4j.Slf4j;
import sun.util.locale.provider.FallbackLocaleProviderAdapter;

/**
 * @author lvlibing
 * @create 2021-07-25 19:16
 */
public class SyncMain {
    public static void main(String[] args) {
        BuyTick buyTick = new BuyTick();
        new Thread(buyTick,"苦逼的我").start();
        new Thread(buyTick,"牛逼的你").start();
        new Thread(buyTick,"可恶的黄牛").start();

    }

}

class BuyTick implements Runnable{
    private int piao=10;
    private Boolean isFlag =true;

    @Override
    public void run() {
        while (isFlag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private boolean buy() throws InterruptedException {
        if(piao<=0){
            isFlag= false;
            return true;
        }
        Thread.sleep(200);
        System.out.println(Thread.currentThread().getName()+"买到了第 "+piao--+" 张票");
        return false;
    }
}

