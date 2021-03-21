package com.ineffable.shopfast.Models.Shop;

import javax.persistence.*;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //this is not an attribute
    protected Long id;

    private String productDistributor;
    private Long productId;
    private Long orderQuantity;



    public Orders() {
    }


    public Orders(String productDistributor, Long productId, Long orderQuantity) {
        this.productDistributor = productDistributor;
        this.productId = productId;
        this.orderQuantity = orderQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductDistributor() {
        return productDistributor;
    }

    public void setProductDistributor(String productDistributor) {
        this.productDistributor = productDistributor;
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
