package com.ineffable.shopfast.Entities;

import com.ineffable.shopfast.Entities.Properties.Color;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TeeShirt extends Clothing {
    private String sleeve;
    private String neck;

/*
    @OneToMany(targetEntity =Color.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "TeeShirt_fk",referencedColumnName = "id")
    List<Color> colors;
*/

    public TeeShirt(Long id, String distributor, double price, double cotton, double polyester, double CBC, String fabricType, Boolean slimfit, String sleeve, String neck) {
        super(id, distributor, price, cotton, polyester, CBC, fabricType, slimfit);
        this.sleeve = sleeve;
        this.neck = neck;
    }

    public TeeShirt(double cotton, double polyester, double CBC, String fabricType, Boolean slimfit, String sleeve, String neck) {
        super(cotton, polyester, CBC, fabricType, slimfit);
        this.sleeve = sleeve;
        this.neck = neck;
    }

    public TeeShirt(String sleeve, String neck) {
        this.sleeve = sleeve;
        this.neck = neck;
    }

    public TeeShirt() {
    }

    public String getSleeve() {
        return sleeve;
    }

    public void setSleeve(String sleeve) {
        this.sleeve = sleeve;
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }
}
