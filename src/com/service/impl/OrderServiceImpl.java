package com.service.impl;

import com.dao.BookDao;
import com.dao.OrderDao;
import com.dao.OrderItemDao;
import com.dao.impl.BookDaoImpl;
import com.dao.impl.OrderDaoImpl;
import com.dao.impl.OrderItemDaoImpl;
import com.pojo.*;
import com.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @program: spring5_demo1
 * @author: yoki
 * @create: 2022-04-17 19:23
 */
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao = new OrderDaoImpl();
    private final OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer user_id) {
        //Order表的 id 为 varchar 类型，如何实现 id 的唯一性
        //*******订单号 id 的唯一性，利用时间戳+用户id
        String order_id = String.valueOf(System.currentTimeMillis() + user_id);

        //保存订单
        orderDao.saveOrder(new Order(order_id, new Date(), cart.getTotalPrice(), 0, user_id));

        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            CartItem cartItem = entry.getValue();

            Book book = bookDao.queryBookById(cartItem.getId());
            //销量sales+
            book.setSales(book.getSales() + cartItem.getCount());
            //库存stock-
            book.setStock(book.getStock() - cartItem.getCount());
            //更新
            bookDao.updateBook(book);

            //保存订单项
            orderItemDao.saveOrderItem(new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), order_id));
        }

        //清空购物车
        cart.clear();
        return order_id;
    }

    @Override
    public List<Order> showAllOrder() {
        return orderDao.queryOrders();
    }

    @Override
    public void sendOrder(String order_id, Integer status) {
        orderDao.updateStatus(order_id, status);
    }

    @Override
    public List<OrderItem> showOrderDetails(String order_id) {
        return orderItemDao.queryOrderItemsByOrderId(order_id);
    }

    @Override
    public List<Order> showMyOrder(Integer user_id) {
        return orderDao.queryOrderByUserId(user_id);
    }

    @Override
    public void receiveOrder(String order_id) {
        orderDao.updateStatus(order_id, 2);
    }
}
