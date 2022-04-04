package com.libing.yygh;


import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

/**
 * @author lvlibing
 * @create 2021-12-05 12:41
 */
@SpringBootTest
public class ServiceOssApplicationTest {


    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;


    @Value("${aliyun.oss.secret}")
    private String secret;

    private String bucketName = "llb-test";



    @Test
    public void  tests1() {
        OSS build = new OSSClientBuilder().build(endpoint, accessKeyId, secret);
        build.createBucket(bucketName);
        build.shutdown();
        System.out.println("success");
    }
    
    @Test
    public void File(){
    
    }
    
    
}
