package com.libing.springbootdata.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * @author lvlibing
 * @create 2021-08-01 23:23
 */
@Data
@ToString
public class User {
    @TableId(type= IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
