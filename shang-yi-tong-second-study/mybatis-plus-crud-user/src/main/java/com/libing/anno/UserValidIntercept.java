package com.libing.anno;

import com.alibaba.fastjson.JSONObject;
import com.libing.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.List;

/**
 * @author lvlibing
 * @create 2021-12-19 19:37
 */

public class UserValidIntercept implements HandlerMethodArgumentResolver {


    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().isAssignableFrom(User.class) && methodParameter.hasParameterAnnotation(UserValid.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
//        ResponseEntity<String> exchange = this.restTemplate().exchange("http://localhost:8899/api/user/all", HttpMethod.GET, new HttpEntity<>(null), String.class);
//        String body = exchange.getBody();
//        JSONObject jsonObject = JSONObject.parseObject(body);
//        List list = (List) jsonObject.get("list");
//        User o = (User) list.get(0);

        return new User("llllllllll","ddddddddd");
    }
}
