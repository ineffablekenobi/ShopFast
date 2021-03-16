package com.ineffable.shopfast.Models.Users;

import com.ineffable.shopfast.Models.Products;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer extends User{


    protected String address;
    protected String phoneNumber;

    @OneToMany(targetEntity = Products.class, cascade = CascadeType.ALL)
    @JoinColumn(name="Customer_fk", referencedColumnName = "id")
    List<Products> products;

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
