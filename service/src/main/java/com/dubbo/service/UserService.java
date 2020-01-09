package com.dubbo.service;

import com.dubbo.pojo.User;

public interface UserService {
    User login(String username);

    User selectUser(String username);
}
