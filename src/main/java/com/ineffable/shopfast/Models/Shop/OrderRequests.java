package com.ineffable.shopfast.Models.Shop;

import javax.persistence.*;
import java.util.List;

@Entity
public class OrderRequests {
    @Id
    @GeneratedValue
    protected Long id;

    private String CustomerName;
    private String Address;
    private String orderDate;
    private String orderTime;

    @ManyToOne(targetEntity = Or)

    @OneToMany(targetEntity = Orders.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "OrderRequest_fk", referencedColumnName = "id")
    public List<Orders> orders;

    public OrderRequests(String customerName, String address, String orderDate, String orderTime) {
        CustomerName = customerName;
        Address = address;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
    }

    public OrderRequests() {
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
