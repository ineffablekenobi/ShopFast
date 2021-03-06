package com.ineffable.shopfast.Models.Shop;

import com.ineffable.shopfast.Models.Products.Products;
import com.ineffable.shopfast.Models.Sales.Invoice;
import com.ineffable.shopfast.Models.Users.Staff;

import javax.persistence.*;
import java.util.List;


@Entity
public class Shop {
    @Id
    @GeneratedValue
    //this is not an attribute
    protected Long id;

    private String name;
    private String address;
    private String phoneNumber;
    private String tradeLicenseNo;

    @OneToMany(targetEntity = Invoice.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "Shop_fk",referencedColumnName = "id")
    public List<Invoice> invoiceList;

    //this is not an attribute
    //can have many Stuff one to Many
    @OneToMany(targetEntity = Staff.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "Shop_fk",referencedColumnName = "id")
    public List<Staff> staffList;

    //this is not an attribute
    //can have many Products
    @OneToMany(targetEntity = Products.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "Shop_fk",referencedColumnName = "id")
    public List<Products> products;


    public Shop(Long id, String name, String address, String phoneNumber, String tradeLicenseNo) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.tradeLicenseNo = tradeLicenseNo;
    }

    public Shop(String name, String address, String phoneNumber, String tradeLicenseNo) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.tradeLicenseNo = tradeLicenseNo;
    }

    public Shop() {
    }

    public Shop(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getTradeLicenseNo() {
        return tradeLicenseNo;
    }

    public void setTradeLicenseNo(String tradeLicenseNo) {
        this.tradeLicenseNo = tradeLicenseNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
