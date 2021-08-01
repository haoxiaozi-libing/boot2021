package com.libing.conf;

import com.libing.proxy.Calcultaor;
import com.libing.proxy.MyMathCatalator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lvlibing
 * @create 2021-08-01 19:29
 */
@Configuration
public class ConfProperties {

    @Bean
    public Calcultaor getCalcultaor(){
        return new MyMathCatalator();
    }


}
