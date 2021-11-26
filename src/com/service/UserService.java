package com.service;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
    @Autowired
    UserDao userDao;
//    UserDao userDao=new UserDaoImpl();
    public Boolean CheckUser(String username, String password){
        return userDao.CheckUser(username,password);
    }
}
