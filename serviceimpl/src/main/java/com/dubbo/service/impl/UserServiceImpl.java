package com.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.mapper.UserMapper;
import com.dubbo.pojo.User;
import com.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String username) {
        return userMapper.login(username);
    }

    @Override
    public User selectUser(String username) {

        return  userMapper.selectUser(username);
    }


}
