package com.service;

import com.pojo.Cart;
import com.pojo.Order;
import com.pojo.OrderItem;

import java.util.List;

/**
 * @program: spring5_demo1
 * @author: yoki
 * @create: 2022-04-17 16:58
 */
public interface OrderService {
    String createOrder(Cart cart, Integer user_id);

    List<Order> showAllOrder();

    void sendOrder(String order_id , Integer status);

    List<OrderItem> showOrderDetails(String order_id);

    List<Order> showMyOrder(Integer user_id);

    void receiveOrder(String order_id);
}
