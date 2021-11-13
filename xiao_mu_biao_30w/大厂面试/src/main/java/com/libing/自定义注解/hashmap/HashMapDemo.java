package com.libing.自定义注解.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvlibing
 * @create 2021-10-08 22:20
 */
public class HashMapDemo {
    public static void main(String[] args) {

        int i = "asdfdasf".hashCode();
        System.out.println(i);

        HashMap map=new HashMap(5);
        map.put("1",1);
    }

}
