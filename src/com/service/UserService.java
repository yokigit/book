package com.service;

import com.pojo.User;

public interface UserService {
    public boolean register(User user);
    public User Login(User user);
    public boolean isExistUsername(String username);
}
