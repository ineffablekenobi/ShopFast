package com.ineffable.shopfast.Models.Users;

import javax.persistence.Entity;

@Entity
public class Staff extends User {


    private String phoneNumber;
    //not part of login
    private String role;

    public Staff(Long id, String username, String password, String email, String phoneNumber, String role) {
        super(id, username, password, email);
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public Staff(String phoneNumber, String role) {
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public Staff(String username, String phoneNumber, String role) {
        super(username);
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public Staff(Long id, String username, String password, String email) {
        super(id, username, password, email);
    }

    public Staff() {
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
