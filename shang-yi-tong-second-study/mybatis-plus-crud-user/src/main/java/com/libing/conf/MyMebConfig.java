package com.libing.conf;

import com.libing.anno.UserValidIntercept;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author lvlibing
 * @create 2021-12-19 20:26
 */
@Configuration
public class MyMebConfig implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(                                       List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new UserValidIntercept());
    }
}
