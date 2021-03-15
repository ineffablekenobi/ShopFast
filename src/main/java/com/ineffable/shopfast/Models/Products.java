package com.ineffable.shopfast.Models;

import com.ineffable.shopfast.Models.Users.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// used as parent of our products
@Entity
public class Products {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    protected Long id;
    private String Distributor;
    private double price;

    // list of customers
    @OneToMany(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id_fk", referencedColumnName = "product_id")
    List<User> users;


    public Products(Long id, String distributor, double price) {
        this.id = id;
        Distributor = distributor;
        this.price = price;
    }

    public Products() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getDistributor() {
        return Distributor;
    }

    public void setDistributor(String distributor) {
        Distributor = distributor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
