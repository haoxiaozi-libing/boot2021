package com.libing.yygh.helper;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvlibing
 * @create 2021-11-20 10:16
 */

class HttpRequestHelperTest {
    public static void main(String[] args) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("hosname","hosname");
        paramMap.put("hostype","hostype");
        paramMap.put("provinceCode","provinceCode");

    }
    public static Map<String, Object> switchMap(Map<String, String[]> paramMap) {
        Map<String, Object> resultMap = new HashMap<>();
        for (Map.Entry<String, String[]> param : paramMap.entrySet()) {
            resultMap.put(param.getKey(), param.getValue()[0]);
        }
        return resultMap;
    }
}