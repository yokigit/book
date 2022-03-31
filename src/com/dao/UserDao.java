package com.dao;

import com.pojo.User;

public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username 用户民
     * @return 返回null，说明该用户不存在
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username 用户名
     * @param password 密码
     * @return 返回null，说明用户名或者密码错误
     */
    public User queryUserByUsernameAndPassword(String username, String password);


    /**
     * 保存用户信息
     */
    public int saveUser(User user);
}
