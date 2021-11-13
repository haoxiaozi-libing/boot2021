package com;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.models.auth.In;
import lombok.Data;
import net.bytebuddy.description.field.FieldDescription;

/**
 * @author lvlibing
 * @create 2021-08-21 13:33
 */
@Data
public class User {

    @ExcelProperty(value = "用户id",index = 0)
    private Integer id;
    @ExcelProperty(value = "用户名称",index = 1)
    private String name;
    @ExcelProperty(value = "用户班级",index = 2)
    private String className;

    public User(Integer id, String name, String className) {
        this.id = id;
        this.name = name;
        this.className = className;
    }

    public User() {
    }
}
