package com.libing.自定义注解.redisson;

import org.junit.jupiter.api.Test;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRedisson {

    @Autowired
    Redisson redisson;

    @Test
    void TestRedio(){
        RLock lock = redisson.getLock("wahaha");
        lock.lock();



    }
}
