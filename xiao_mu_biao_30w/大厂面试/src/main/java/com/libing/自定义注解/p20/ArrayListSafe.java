package com.libing.自定义注解.p20;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lvlibing
 * @create 2021-09-23 6:53
 */
public class ArrayListSafe {
    public static void main(String[] args) {
        List<String> list= new Vector<>();Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString());
                System.out.println(list);
            },String.valueOf(i)).start();
            List lists=new CopyOnWriteArrayList<String>();
            lists.add("");


        }
    }
}
