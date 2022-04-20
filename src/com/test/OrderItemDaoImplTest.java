package com.test;

import com.dao.OrderItemDao;
import com.dao.impl.OrderItemDaoImpl;
import com.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class OrderItemDaoImplTest {

    OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Test
    public void saveOrderItem() {
        orderItemDao.saveOrderItem(new OrderItem(null, "怎样拐跑别人的媳妇", 1, new BigDecimal(68), new BigDecimal(68), "1"));
        orderItemDao.saveOrderItem(new OrderItem(null, "木虚肉盖饭", 1, new BigDecimal(16), new BigDecimal(16), "1"));

    }

    @Test
    public void queryOrderItemByOrderId() {
        List<OrderItem> orderItems = orderItemDao.queryOrderItemsByOrderId("1");
        System.out.println(orderItems);
    }
}