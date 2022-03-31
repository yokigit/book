package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.pojo.User;
import com.service.UserService;

public class UserServiceImpl implements UserService {

    private final UserDao userDao=new UserDaoImpl();
    @Override
    public boolean register(User user) {
        if(userDao.saveUser(user)!=-1){
            return true;
        }
        return false;
    }

    @Override
    public User Login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean isExistUsername(String username) {
        if(userDao.queryUserByUsername(username)==null){
            return false;
        }
        return true;
    }
}
