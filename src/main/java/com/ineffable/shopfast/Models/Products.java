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

    @OneToMany(targetEntity =Color.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "Customer_fk",referencedColumnName = "product_id")
    List<Color> colors;

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

}
