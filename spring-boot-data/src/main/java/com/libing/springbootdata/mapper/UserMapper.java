package com.libing.springbootdata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.libing.springbootdata.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author lvlibing
 * @create 2021-08-01 23:26
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
