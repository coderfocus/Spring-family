package com.coderfocus.dao.impl;

import com.coderfocus.dao.UserDao;
import com.coderfocus.entity.User;

public class UserDaoImpl implements UserDao {
    public User getUSer(){
        User user =new User();
        user.setName("coderfocus");
        user.setEmail("coderfocus@163.com");
        return user;
    }
}
