package com.dao.impl;

import com.dao.UserDao;
import com.mapper.UserMapper;
import com.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Override
    public Boolean CheckUser(String username, String password) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationcontext-dao.xml");
        UserMapper userMapper= (UserMapper) ac.getBean("userMapper");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        int row=userMapper.QueryUserByIdAndPassword(user);
        if (row>=1)return true;
        return false;
    }
}
