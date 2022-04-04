package com.libing.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libing.mapper.UserMapper;
import com.libing.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author lvlibing
 * @create 2021-12-18 23:08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
