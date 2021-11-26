package com.mapper;

import com.pojo.User;

import java.util.List;



public interface UserMapper {
    List<User> QueryAllUsers();
    User QueryUserById(int id);
    int QueryUserByIdAndPassword(User user);
}
