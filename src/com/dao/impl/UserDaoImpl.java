package com.dao.impl;

import com.dao.UserDao;
import com.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    /**
     *
     * @param username 用户名
     * @return
     */
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select * from table_user where username=?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql="select * from table_user where username=? and password=?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql="insert into table_user(username, password, email) values(?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
