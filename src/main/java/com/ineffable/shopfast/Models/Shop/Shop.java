package com.ineffable.shopfast.Models.Shop;

import javax.persistence.*;


@Entity
public class Shop {
    @Id
    @GeneratedValue
    protected Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String tradeLicenseNo;

    //can have many Stuff one to Many
    //can have Customers List
    //can have many Products


    public Shop( String name, String address, String phoneNumber, String tradeLicenseNo) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.tradeLicenseNo = tradeLicenseNo;
    }

    public Shop() {
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
}
