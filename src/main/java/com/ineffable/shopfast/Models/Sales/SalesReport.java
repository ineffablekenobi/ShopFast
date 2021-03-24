package com.ineffable.shopfast.Models.Sales;

import com.ineffable.shopfast.Models.Users.User;

import javax.persistence.*;

@Entity
public class SalesReport {
    @Id
    @GeneratedValue
    private Long id;

    private String userType;

    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_fk", referencedColumnName = "id")
    public User user;

    @OneToOne(targetEntity = Invoice.class,cascade = CascadeType.ALL)
    public Invoice invoice;

    private Double totalWorth;

    public SalesReport() {
    }

    public SalesReport(Long id, String userType, Double totalWorth) {
        this.id = id;
        this.userType = userType;
        this.totalWorth = totalWorth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Double getTotalWorth() {
        return totalWorth;
    }

    public void setTotalWorth(Double totalWorth) {
        this.totalWorth = totalWorth;
    }
}
