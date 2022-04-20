package com.dao.impl;

import com.dao.OrderItemDao;
import com.pojo.OrderItem;

import java.util.List;

/**
 * @program: spring5_demo1
 * @author: yoki
 * @create: 2022-04-17 18:45
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public void saveOrderItem(OrderItem orderItem) {
        String sql = "insert into table_order_item(id, name, count, price, totalPrice, order_id) values(?,?,?,?,?,?) ";
        update(sql, null, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrder_id());
    }

    @Override
    public List<OrderItem> queryOrderItemsByOrderId(String order_id) {
        String sql = "select * from table_order_item where order_id =?";
        return queryForList(OrderItem.class, sql, order_id);
    }
}
