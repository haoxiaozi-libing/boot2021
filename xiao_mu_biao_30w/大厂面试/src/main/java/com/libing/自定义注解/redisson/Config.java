package com.libing.自定义注解.redisson;

import org.redisson.Redisson;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    public Redisson redisson(){
        org.redisson.config.Config config=new org.redisson.config.Config();
        config.useSingleServer().setAddress("localhost:6379").setDatabase(0);
        return (Redisson)Redisson.create(config);
    }
}
