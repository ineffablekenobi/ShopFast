package com.ineffable.shopfast.Dto;

import com.ineffable.shopfast.Models.Users.Customer;

public class CheckoutCustomer extends CheckoutRequest {

    private Long customerId;

    public CheckoutCustomer(String name, String phoneNumber, String age, String city, String district, Long customerId) {
        super(name, phoneNumber, age, city, district);
        this.customerId = customerId;
    }

    public CheckoutCustomer(Long customerId) {
        this.customerId = customerId;
    }


    public CheckoutCustomer(String name, String phoneNumber, String age, String city, String district) {
        super(name, phoneNumber, age, city, district);
    }

    public CheckoutCustomer() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
