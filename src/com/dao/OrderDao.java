package com.dao;

import com.pojo.Order;

import java.util.List;

/**
 * @program: spring5_demo1
 * @author: yoki
 * @create: 2022-04-17 17:17
 */
public interface OrderDao {
    void saveOrder(Order order);

    List<Order> queryOrders();

    int updateStatus(String order_id, Integer status);

    List<Order> queryOrderByUserId(Integer userId);
}
