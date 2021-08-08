package com.libing.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

/**
 * @author lvlibing
 * @create 2021-08-08 18:23
 */
@Configuration
@MapperScan("com.libing.mapper")
public class HospSetMapperConfig {
}
