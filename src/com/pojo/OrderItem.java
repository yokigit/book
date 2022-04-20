package com.pojo;

import java.math.BigDecimal;

/**
 * @program: spring5_demo1
 * @author: yoki
 * @create: 2022-04-17 16:53
 */
public class OrderItem {
    private Integer id;
    private String name;
    private Integer count;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private String order_id;

    public OrderItem() {
    }

    public OrderItem(Integer id, String name, Integer count, BigDecimal price, BigDecimal totalPrice, String order_id) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalPrice = totalPrice;
        this.order_id = order_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String orderId) {
        this.order_id = orderId;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                ", order_id=" + order_id +
                '}';
    }
}
