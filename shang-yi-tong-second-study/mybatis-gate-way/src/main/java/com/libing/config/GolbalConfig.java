package com.libing.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author lvlibing
 * @create 2021-12-19 14:39
 */

@Configuration
public class GolbalConfig implements GlobalFilter, Ordered {

    private AntPathMatcher antPathMatcher=new AntPathMatcher();
    @Autowired
    RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        URI uri = exchange.getRequest().getURI();
//        String path = uri.getPath();
//        System.out.println(path+"==============================");
//        if (antPathMatcher.match("/api/user/**",path)) {
//            List<String> list = exchange.getRequest().getHeaders().get("token");
//            String s = list.get(0);
//            if(StringUtils.isEmpty(s)){
//                ServerHttpResponse response = exchange.getResponse();
//                byte[] bytes = JSONObject.toJSONString("您没有登录，请先登录").getBytes(StandardCharsets.UTF_8);
//                DataBuffer wrap = response.bufferFactory().wrap(bytes);
//                return response.writeWith(Mono.just(wrap));
//            }
//
//            return chain.filter(exchange);
//        }else {
//            // api接口鉴权失败
//        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
