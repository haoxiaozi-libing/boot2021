package com.libing.yygh.user.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.libing.yygh.user.mapper")
public class UserConfig {
}
