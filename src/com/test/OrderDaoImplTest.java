package com.test;

import com.dao.OrderDao;
import com.dao.impl.OrderDaoImpl;
import com.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderDaoImplTest {

    OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void saveOrder() {
        orderDao.saveOrder(new Order("1", new Date(), new BigDecimal(84), 0, 1));
    }

    @Test
    public void queryOrders() {
        List<Order> orderList = orderDao.queryOrders();
        System.out.println(orderList);
    }

    @Test
    public void updateStatus() {
        int row = orderDao.updateStatus("1", 1);
        System.out.println(row);
    }

    @Test
    public void queryOrderByUserId() {
        List<Order> orderList = orderDao.queryOrderByUserId(1);

        System.out.println(orderList);
    }
}