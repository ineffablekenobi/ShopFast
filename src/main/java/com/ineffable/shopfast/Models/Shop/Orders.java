package com.ineffable.shopfast.Models.Shop;

import com.ineffable.shopfast.Models.Products.Products;

import javax.persistence.*;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //this is not an attribute
    protected Long id;

    private Long productId;
    private Long orderQuantity;

    public Orders() {
    }


    public Orders(Long productId, Long orderQuantity) {
        this.productId = productId;
        this.orderQuantity = orderQuantity;
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
}
