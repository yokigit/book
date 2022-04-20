package com.test;

import com.dao.ManagerDao;
import com.dao.impl.ManagerDaoImpl;
import com.pojo.Manager;
import org.junit.Test;

public class ManagerDaoImplTest {

    @Test
    public void queryManagerByUsernameAndPassword() {
        ManagerDao managerDao = new ManagerDaoImpl();
        Manager manager = managerDao.queryManagerByUsernameAndPassword("root", "root");
        System.out.println(manager);
    }
}