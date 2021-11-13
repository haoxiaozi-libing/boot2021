package com.libing.cmn;

import com.libing.cmn.pojo.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author lvlibing
 * @create 2021-08-22 21:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceCmnApplication.class)
@WebAppConfiguration
public class ServiceCmnApplication {

    @Autowired
    private MongoTemplate mongoTemplate;

    //添加
    @Test
    public void createUser() {
        User user = new User();
        user.setAge(20);
        user.setName("test");
        user.setEmail("4932200@qq.com");
        User user1 = mongoTemplate.insert(user);
        System.out.println(user1);
    }
}
