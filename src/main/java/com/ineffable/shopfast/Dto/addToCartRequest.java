package com.ineffable.shopfast.Dto;

import com.ineffable.shopfast.Models.Shop.Orders;

public class addToCartRequest {
    private Long userId;
    private Orders orders;

    public addToCartRequest(Long userId, Orders orders) {
        this.userId = userId;
        this.orders = orders;
    }

    public addToCartRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
