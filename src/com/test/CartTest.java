package com.test;

import com.pojo.Cart;
import com.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "a", 1, new BigDecimal(1)));
        cart.addItem(new CartItem(1, "a", 1, new BigDecimal(1)));
        cart.addItem(new CartItem(2, "b", 1, new BigDecimal(2)));

        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "a", 1, new BigDecimal(1)));
        cart.addItem(new CartItem(1, "a", 1, new BigDecimal(1)));
        cart.addItem(new CartItem(2, "b", 1, new BigDecimal(2)));
        cart.deleteItem(2);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "a", 1, new BigDecimal(1)));
        cart.addItem(new CartItem(1, "a", 1, new BigDecimal(1)));
        cart.addItem(new CartItem(2, "b", 1, new BigDecimal(2)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "a", 1, new BigDecimal(1)));
        cart.addItem(new CartItem(1, "a", 1, new BigDecimal(1)));
        cart.addItem(new CartItem(2, "b", 1, new BigDecimal(2)));
        cart.updateCount(1, 3);
        System.out.println(cart);
    }


}