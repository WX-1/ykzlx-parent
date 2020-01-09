package com.dubbo.mapper;

import com.dubbo.pojo.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    @Select("select * from t_user where username=#{username}")
    User login(String username);

    @Select("select * from t_user where username=#{username}")
    User selectUser(String username);
}