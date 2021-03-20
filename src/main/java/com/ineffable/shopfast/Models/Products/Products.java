package com.ineffable.shopfast.Models.Products;

import com.ineffable.shopfast.Models.Properties.Color;

import javax.persistence.*;
import java.util.List;

// used as parent of our products
@Entity
public class Products {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    //this is not an attribute
    protected Long id;

    private String Distributor;
    private Long quantity;
    private double price;

    /*
    //this is not an attribute
    @OneToMany(targetEntity = Color.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "Colors_fk",referencedColumnName = "product_id")
    List<Color> colors;
    */

    public Products(String distributor, Long quantity, double price) {
        Distributor = distributor;
        this.quantity = quantity;
        this.price = price;
    }

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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
