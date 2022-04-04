package com.libing.conf;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author lvlibing
 * @create 2021-12-19 20:39
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public String error(YyghExeception exeception) {
        return "发生错误了";
    }
}
