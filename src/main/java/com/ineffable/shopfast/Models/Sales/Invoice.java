package com.ineffable.shopfast.Models.Sales;
import com.ineffable.shopfast.Models.Products.Products;
import com.ineffable.shopfast.Models.Shop.Orders;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String addreess;
    private String phonenumber;
    private String paymentMethod;
    private boolean invoiceForDB;

    @ManyToMany
    public List<Orders> ordersList;

    public Invoice(Long id, String name, String addreess, String phonenumber, String paymentMethod) {
        this.id = id;
        this.name = name;
        this.addreess = addreess;
        this.phonenumber = phonenumber;
        this.paymentMethod = paymentMethod;
    }

    public Invoice(boolean invoiceForDB) {
        this.invoiceForDB = invoiceForDB;
    }

    public Invoice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddreess() {
        return addreess;
    }

    public void setAddreess(String addreess) {
        this.addreess = addreess;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isInvoiceForDB() {
        return invoiceForDB;
    }

    public void setInvoiceForDB(boolean invoiceForDB) {
        this.invoiceForDB = invoiceForDB;
    }
}
