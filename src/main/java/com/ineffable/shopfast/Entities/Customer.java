package com.ineffable.shopfast.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer extends User{


    String address;
    String phoneNumber;

    @OneToMany(targetEntity = Products.class, cascade = CascadeType.ALL)
    @JoinColumn(name="User_fk", referencedColumnName = "id")
    List<Products> products;

    public Customer(Long id, String username, String password, String email, String address, String phoneNumber, List<Products> products) {
        super(id, username, password, email);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.products = products;
    }

    public Customer(String address, String phoneNumber, List<Products> products) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.products = products;
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

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}
