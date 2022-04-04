package com.libing.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.libing.anno.UserValid;
import com.libing.conf.YyghExeception;
import com.libing.pojo.User;
import com.libing.response.RestultResponse;
import com.libing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lvlibing
 * @create 2021-12-18 23:04
 */

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserService userService;

    @DeleteMapping("/delete")
    public void testOne() {
        userService.removeById("5");
    }

    @GetMapping("/all")
    public RestultResponse getList(@UserValid User user) {
        System.out.println(user.toString());
        PageHelper.startPage(2, 2);
        List<User> list = userService.list(null);
        PageInfo pageInfo = new PageInfo<User>(list);
        return RestultResponse.ok(pageInfo);
    }

    @GetMapping("/add")
    public void addUser() {

        User user = userService.getById(18l);
        user.setName("wagnhaha ");
        user.setPassword("88888888888888");
        try {
            int i = 10 / 0;
        } catch (Exception e) {
            throw new YyghExeception("cuowu l ", 100);
        }
        userService.save(user);
    }


}
