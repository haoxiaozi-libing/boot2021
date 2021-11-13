package com.libing.springbootdata;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.libing.springbootdata.entity.User;
import com.libing.springbootdata.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringBootDataApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null); // 查询
        System.out.println(users);
    }


    @Test
    void insert() {
        User zhangsan = new User("kk");
        int rows = userMapper.insert(zhangsan); // 插入
        System.out.println(rows);
    }

    @Test
    void optLock() {
        User user = userMapper.selectById("1423627487413792779"); // 更新
        user.setAge(15);
        userMapper.updateById(user);
    }

    @Test
    void selectBeach() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList("1423627487413792771","1423627487413792772"));
        users.forEach(user-> System.out.println(user));
    }

    @Test
    void findByIdAndAge() {
        Map<String,Object> map=new HashMap<>();
        map.put("id","1423627487413792779");
        map.put("age","15");
        List<User> users = userMapper.selectByMap(map);
        System.out.println(users);
    }


    @Test
    void page() {
        Page<User> page=new Page(1,3);
        Page<User> userPage = userMapper.selectPage(page, null);
        System.out.println(userPage);
    }

    @Test
    public void testSelectMapsPage() {
//Page不需要泛型
        Page<Map<String, Object>> page = new Page<>(1, 5);
        Page<Map<String, Object>> pageParam = userMapper.selectMapsPage(page, null);
        List<Map<String, Object>> records = pageParam.getRecords();
        records.forEach(System.out::println);
        System.out.println(pageParam.getCurrent());
        System.out.println(pageParam.getPages());
        System.out.println(pageParam.getSize());
        System.out.println(pageParam.getTotal());
        System.out.println(pageParam.hasNext());
        System.out.println(pageParam.hasPrevious());
    }


}
