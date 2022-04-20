package com.dao.impl;

import com.dao.ManagerDao;
import com.pojo.Manager;

/**
 * @program: spring5_demo1
 * @author: yoki
 * @create: 2022-04-20 09:52
 */
public class ManagerDaoImpl extends BaseDao implements ManagerDao {
    @Override
    public Manager queryManagerByUsernameAndPassword(String username, String password) {
        String sql = "select * from table_manager where username=? and password=?";
        return queryForOne(Manager.class, sql, username, password);
    }
}
