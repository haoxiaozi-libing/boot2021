package com.libing.pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lvlibing
 * @create 2021-12-18 23:02
 */
@NoArgsConstructor
@Data
public class User implements Serializable {
    private int id;
    private String name;
    private String password;
    @TableLogic
    private Integer logicId;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
