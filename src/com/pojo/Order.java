package com.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: spring5_demo1
 * @author: yoki
 * @create: 2022-04-17 16:47
 */
public class Order {
    private String id;
    private Date createTime;
    private BigDecimal totalPrice;
    private Integer status;
    private Integer user_id;

    public Order() {
    }

    public Order(String id, Date createTime, BigDecimal totalPrice, Integer status, Integer user_id) {
        this.id = id;
        this.createTime = createTime;
        this.totalPrice = totalPrice;
        this.status = status;
        this.user_id = user_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer userId) {
        this.user_id = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                ", user_id=" + user_id +
                '}';
    }
}
