package com.libing.cmn.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lvlibing
 * @create 2022-01-09 17:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String username;
    private int  age;
    private Adress adress;
}
