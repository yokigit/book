package com.dao.impl;

import com.dao.OrderDao;
import com.pojo.Order;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public void saveOrder(Order order) {
        String sql = "insert into table_order(id, createTime, totalPrice, status, user_id) values(?,?,?,?,?)";
        update(sql, order.getId(), order.getCreateTime(), order.getTotalPrice(), order.getStatus(), order.getUser_id());
    }

    @Override
    public List<Order> queryOrders() {
        String sql = "select * from table_order";
        return queryForList(Order.class, sql);
    }

    @Override
    public int updateStatus(String order_id, Integer status) {
        String sql = "update table_order set status=? where id=?";
        return update(sql, status, order_id);
    }

    @Override
    public List<Order> queryOrderByUserId(Integer userId) {
        String sql = "select * from table_order where user_id=?";
        return queryForList(Order.class, sql, userId);
    }
}
