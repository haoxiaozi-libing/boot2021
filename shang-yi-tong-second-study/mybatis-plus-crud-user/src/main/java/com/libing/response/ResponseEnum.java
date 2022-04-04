package com.libing.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @author lvlibing
 * @create 2021-12-19 17:19
 */
@Getter
public enum ResponseEnum {
    ERROR(500, "错误了"),

    SUCCESS(200,"成功了")
            ;

    private Integer status;
    private String message;

    ResponseEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

}
