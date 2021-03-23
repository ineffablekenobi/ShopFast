package com.ineffable.shopfast.Models.Shop;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue
    protected Long id;

    @OneToMany(targetEntity = Orders.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "Cart_fk", referencedColumnName = "id")
    public List<Orders> ordersList;

    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
