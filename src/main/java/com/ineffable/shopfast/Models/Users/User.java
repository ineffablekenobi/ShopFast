package com.ineffable.shopfast.Models.Users;

import com.ineffable.shopfast.Models.Shop.Cart;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue
    protected Long id;

    protected String username;
    protected String password;
    protected String email;
    //not used for login
    protected boolean active;

    @OneToOne(targetEntity = Cart.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "Cart_fk", referencedColumnName = "id")
    public Cart cart;


    public User(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.cart = new Cart();
    }



    public User() {
        this.cart = new Cart();
    }

    public User(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }



}
