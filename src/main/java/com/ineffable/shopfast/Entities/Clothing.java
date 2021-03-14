package com.ineffable.shopfast.Entities;

import javax.persistence.*;

@Entity
public class Clothing extends Products{
    // percentage of materials
    private double cotton;
    private double polyester;
    private double CBC;



    //Fabric
    String fabricType;

    //Properties
    Boolean slimfit;


    public Clothing(Long id, String distributor, double price, double cotton, double polyester, double CBC, String fabricType, Boolean slimfit) {
        super(id, distributor, price);
        this.cotton = cotton;
        this.polyester = polyester;
        this.CBC = CBC;
        this.fabricType = fabricType;
        this.slimfit = slimfit;
    }

    public Clothing(double cotton, double polyester, double CBC, String fabricType, Boolean slimfit) {
        this.cotton = cotton;
        this.polyester = polyester;
        this.CBC = CBC;
        this.fabricType = fabricType;
        this.slimfit = slimfit;
    }

    public Clothing() {
    }

    public double getCotton() {
        return cotton;
    }

    public void setCotton(double cotton) {
        this.cotton = cotton;
    }

    public double getPolyester() {
        return polyester;
    }

    public void setPolyester(double polyester) {
        this.polyester = polyester;
    }

    public double getCBC() {
        return CBC;
    }

    public void setCBC(double CBC) {
        this.CBC = CBC;
    }

    public String getFabricType() {
        return fabricType;
    }

    public void setFabricType(String fabricType) {
        this.fabricType = fabricType;
    }

    public Boolean getSlimfit() {
        return slimfit;
    }

    public void setSlimfit(Boolean slimfit) {
        this.slimfit = slimfit;
    }
}
