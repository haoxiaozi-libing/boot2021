package com.libing;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.libing.entity.Course;
import com.libing.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test {

    @Autowired
    CourseMapper courseMapper;

    @org.junit.jupiter.api.Test
    void Test() {
        courseMapper.insert(new Course("libing",100L,"0"));
        courseMapper.insert(new Course("HAOXIAOZI",100L,"0"));


    }
}
