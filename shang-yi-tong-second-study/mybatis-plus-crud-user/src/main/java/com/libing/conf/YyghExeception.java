package com.libing.conf;

import com.libing.response.ResponseEnum;

/**
 * @author lvlibing
 * @create 2021-12-19 17:17
 */
public class YyghExeception extends RuntimeException {
    private Integer status;

    public YyghExeception(String message, Integer status) {
        super(message);
        this.status = status;
    }

    public YyghExeception(ResponseEnum responseEnum) {
        super(responseEnum.getMessage());
        this.status = responseEnum.getStatus();
    }
}
