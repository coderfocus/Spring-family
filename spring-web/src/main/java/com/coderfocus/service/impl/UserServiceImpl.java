package com.coderfocus.service.impl;

import com.coderfocus.commons.context.SpringContext;
import com.coderfocus.dao.UserDao;
import com.coderfocus.entity.User;
import com.coderfocus.service.UserService;
import org.springframework.context.ApplicationContext;

public class UserServiceImpl implements UserService {
    ApplicationContext context =  null;

    @Override
    public User getUser() {
        UserDao userDao = (UserDao)SpringContext.getBean("userDao");
        return userDao.getUSer();
    }
}
