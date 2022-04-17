package com.pojo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: spring5_demo1
 * @author: yoki
 * @create: 2022-04-16 14:44
 */
public class Cart {
    private Map<Integer, CartItem> items = new HashMap<Integer, CartItem>();

    //不必要的
//    private Integer totalCount;
//    private BigDecimal totalPrice;

    public Cart(Map<Integer, CartItem> items) {
        this.items = items;
    }

    public Cart() {
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    //这两个set()方法不必要定义，因为totalCount, totalPrice 需要遍历items才能得到
    /*
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
     */

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }

//        for (CartItem item : items.values()) {
//            totalCount += item.getCount();
//        }

        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            //BigDecimal的用法
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                ", totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }

    public void addItem(CartItem cartItem) {
        CartItem item = items.get(cartItem.getId());
        if (item == null) {
            items.put(cartItem.getId(), cartItem);
        } else {
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    public void deleteItem(Integer id) {
        items.remove(id);
    }

    public void clear() {
        items.clear();
    }

    public void updateCount(Integer id, Integer count) {
        if (items.containsKey(id)) {
            CartItem item = items.get(id);
            item.setCount(count);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }
}
