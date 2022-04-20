package com.test;

import com.pojo.Cart;
import com.pojo.CartItem;
import com.service.OrderService;
import com.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderServiceImplTest {
    private final OrderService orderService = new OrderServiceImpl();


    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(3, "怎样拐跑别人的媳妇", 1, new BigDecimal(68)));
        cart.addItem(new CartItem(4, "木虚肉盖饭", 1, new BigDecimal(16)));
        cart.addItem(new CartItem(3, "怎样拐跑别人的媳妇", 1, new BigDecimal(68)));

        orderService.createOrder(cart, 1);
    }

    @Test
    public void showAllOrder() {
        System.out.println(orderService.showAllOrder());
    }

    @Test
    public void sendOrder() {
        orderService.sendOrder("1650199392465",1);
    }

    @Test
    public void showOrderDetails() {
        System.out.println(orderService.showOrderDetails("1650199392465"));
    }

    @Test
    public void showMyOrder() {
        System.out.println(orderService.showMyOrder(1));
    }

    @Test
    public void receiveOrder() {
        orderService.receiveOrder("1650280770187");
    }
}