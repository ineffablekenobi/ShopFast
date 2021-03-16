package com.ineffable.shopfast.Models.Shop;

import javax.persistence.*;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;
    private String customerName;
    private Long customerId;
    private String customerPhoneNumber;
    private String productDistributor;
    private Long productId;
    private String orderDate;
    private String orderTime;
    private Long orderQuantity;

    public Orders(String customerName, Long customerId, String customerPhoneNumber, String productDistributor, Long productId, String orderDate, String orderTime, Long orderQuantity) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.customerPhoneNumber = customerPhoneNumber;
        this.productDistributor = productDistributor;
        this.productId = productId;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.orderQuantity = orderQuantity;
    }

    public Orders() {
    }



    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
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

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Long getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Long orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
}
