package com.libing.自定义注解.suanfa;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvlibing
 * @create 2021-09-25 17:28
 */
public class QiuHe {

    public static void main(String[] args) {

        int arr[]={1,3,25,6,4,8};
        int target=29;
        Map map=new HashMap();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                int companyNum=target-arr[i]-arr[j];
                if(map.containsKey(companyNum)){
                    System.out.println(map.get(companyNum)+"--->"+i+j);
                }
                map.put(arr[i],i);
            }
        }


    }

}
