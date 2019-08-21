package com.mapper;

import com.entity.User;

import java.util.List;

public interface UserMapper {
    /*
    * 用户列表
    * */
    List<User> userList();

    /*
    *删除用户
    * */
    int deleteUser(Integer user_id);

    /*
    * 更新用户
    * */
    void updateUser(User user);

    /*
    * 添加用户
    * */
    void insertUser(User user);
}
