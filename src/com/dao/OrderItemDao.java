package com.dao;

import com.pojo.OrderItem;

import java.util.List;

public interface OrderItemDao {

    void saveOrderItem(OrderItem orderItem);

    List<OrderItem> queryOrderItemsByOrderId(String order_id);
}
