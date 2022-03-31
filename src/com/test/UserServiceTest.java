package com.test;

import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserServiceTest {
    @Test
    public void test(){
        UserService userService=new UserServiceImpl();

//        userService.register(new User(null, "admin","admin123", "admin@163.com"));

//        System.out.println(userService.isExistUsername("admin"));

        System.out.println(userService.Login(new User(null, "admin", "admin123", "admin@163.com")));

    }
}
