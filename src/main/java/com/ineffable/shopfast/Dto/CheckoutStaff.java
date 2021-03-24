package com.ineffable.shopfast.Dto;

import com.ineffable.shopfast.Models.Users.Customer;
import com.ineffable.shopfast.Models.Users.Staff;
import com.ineffable.shopfast.Models.Users.User;

public class CheckoutStaff extends CheckoutRequest {
    private Long staffId;

    // if user has an account
    private Customer customer;


    public CheckoutStaff(String name, String phoneNumber, String age, String city, String district, Long staffId, Customer customer) {
        super(name, phoneNumber, age, city, district);
        this.staffId = staffId;
        this.customer = customer;
    }

    public CheckoutStaff(Long staffId, Customer customer) {
        this.staffId = staffId;
        this.customer = customer;
    }

    public CheckoutStaff(String name, String phoneNumber, String age, String city, String district) {
        super(name, phoneNumber, age, city, district);
    }

    public CheckoutStaff() {
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
