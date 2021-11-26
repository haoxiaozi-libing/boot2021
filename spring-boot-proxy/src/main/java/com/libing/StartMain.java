package com.libing;

import com.libing.aop.MyMathCatalator;
import com.libing.proxy.Calcultaor;
import com.libing.proxy.CalcultaorProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author lvlibing
 * @create 2021-08-01 16:09
 */
@SpringBootApplication
public class StartMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(StartMain.class, args);
//        MyMathCatalator bean = run.getBean(MyMathCatalator.class);
//        int add = bean.add(1, 2);
    }
}
