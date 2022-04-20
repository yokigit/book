package com.service.impl;

import com.dao.ManagerDao;
import com.dao.impl.ManagerDaoImpl;
import com.pojo.Manager;
import com.service.ManagerService;

/**
 * @program: spring5_demo1
 * @author: yoki
 * @create: 2022-04-20 10:04
 */
public class ManagerServiceImpl implements ManagerService {
    ManagerDao managerDao = new ManagerDaoImpl();

    @Override
    public Manager login(String username, String password) {
        return managerDao.queryManagerByUsernameAndPassword(username, password);
    }
}
