package com.ineffable.shopfast.Models.Products;

import com.ineffable.shopfast.Models.Properties.Color;
import com.ineffable.shopfast.Models.Shop.Shop;

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

    private String productName;
    private String Distributor;
    private Long quantity;
    private double price;
    private String Description;
    private Long shopId;

    //not added to create product
    private String imageData;

    //not added to frontend
    private Long soldUnits;


    /*
    //this is not an attribute
    @OneToMany(targetEntity = Color.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "Colors_fk",referencedColumnName = "product_id")
    List<Color> colors;
    */

    public Products(String productName, String distributor, Long quantity, double price, String description, String imageData) {
        this.productName = productName;
        Distributor = distributor;
        this.quantity = quantity;
        this.price = price;
        Description = description;
        this.imageData = imageData;
    }

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

    public Products(String productName) {
        this.productName = productName;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void  updateSold(Long sold){
        this.soldUnits += sold;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getSoldUnits() {
        return soldUnits;
    }

    public void setSoldUnits(Long soldUnits) {
        this.soldUnits = soldUnits;
    }
}
