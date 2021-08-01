package com.libing;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @author lvlibing
 * @create 2021-07-25 18:49
 */
public class 倒计时 {

    public static int i = 10;

    public static void main(String[] args) throws InterruptedException {
        Date date = new Date(System.currentTimeMillis());

        while (true) {
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
            Thread.sleep(1000);
            if (--i == 0) {
                break;
            }
            date = new Date(System.currentTimeMillis());
        }


    }
}
