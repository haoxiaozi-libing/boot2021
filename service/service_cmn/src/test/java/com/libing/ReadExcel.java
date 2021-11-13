package com.libing;

import com.MyListen;
import com.User;
import com.alibaba.excel.EasyExcel;

import javax.jws.soap.SOAPBinding;

/**
 * @author lvlibing
 * @create 2021-08-21 13:48
 */
public class ReadExcel {
    public static void main(String[] args) {

        String fileName="E:\\project\\springcloud\\yygh\\excel.xls";
        EasyExcel.read(fileName, User.class,new MyListen()).sheet().doRead();


    }
}
