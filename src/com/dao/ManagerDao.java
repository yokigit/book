package com.dao;

import com.pojo.Manager;

/**
 * @program: spring5_demo1
 * @author: yoki
 * @create: 2022-04-20 09:48
 */
public interface ManagerDao {
    Manager queryManagerByUsernameAndPassword(String username, String password);
}
