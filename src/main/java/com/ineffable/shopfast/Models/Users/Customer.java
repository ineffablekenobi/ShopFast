package com.ineffable.shopfast.Models.Users;

import javax.persistence.Entity;

@Entity
public class Customer extends User{


    protected String address;
    protected String phoneNumber;


    public Customer(Long id, String username, String password, String email, String address, String phoneNumber) {
        super(id, username, password, email);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String name){
        this.username = name;
    }

    public Customer(Long id, String username, String password, String email) {
        super(id, username, password, email);
    }

    public Customer() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
