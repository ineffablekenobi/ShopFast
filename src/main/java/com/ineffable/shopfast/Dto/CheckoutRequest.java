package com.ineffable.shopfast.Dto;

public abstract class CheckoutRequest {
    protected String name;
    protected String phoneNumber;
    //make optional
    protected String age;
    //make optional
    protected String city;
    //make optional
    protected String district;

    protected String paymentMethod;

    public CheckoutRequest(String name, String phoneNumber, String age, String city, String district) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.city = city;
        this.district = district;
    }

    public CheckoutRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
