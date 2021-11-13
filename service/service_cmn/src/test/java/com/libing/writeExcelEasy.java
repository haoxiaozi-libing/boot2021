package com.libing;

import com.User;
import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvlibing
 * @create 2021-08-21 13:30
 */

public class writeExcelEasy {

    public static void main(String[] args) {
        String fileName="E:\\project\\springcloud\\yygh\\excel.xls";

        List<User> users=new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            User user=new User(i,"zhangsan"+i+"号",i+"班级");
            users.add(user);
        }
        EasyExcel.write(fileName, User.class).sheet("用户信息").doWrite(users);

    }
}
