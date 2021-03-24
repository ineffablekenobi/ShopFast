package com.ineffable.shopfast.Models.Shop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //this is not an attribute
    protected Long id;

    private Long productId;
    private Long orderQuantity;


    //this not an attribute for frontend
    private boolean confirmed;

    private final Date orderDate = new Date(System.currentTimeMillis());

    public Orders() {
    }


    public Orders(Long productId, Long orderQuantity) {
        this.productId = productId;
        this.orderQuantity = orderQuantity;
        this.confirmed = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Long orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}
