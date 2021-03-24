package com.ineffable.shopfast.Controllers;

import com.ineffable.shopfast.Dto.*;
import com.ineffable.shopfast.Models.Sales.Invoice;
import com.ineffable.shopfast.Models.Shop.Cart;
import com.ineffable.shopfast.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService add;

    @PutMapping("/addToCart")
    public Cart addToCart(@RequestBody addToCartRequest request){
        return add.addToCart(request);
    }

    @PutMapping("/removeFromCart")
    public Cart removeFromCart(@RequestBody RemoveFromCartRequest request){
        return add.removeFromCart(request);
    }

    @GetMapping("/getCart/{userid}")
    public Cart getCart(@PathVariable("userid")Long userid){
        return add.getCart(userid);
    }

    @PutMapping("/CustomerCheckout")
    public Invoice checkOut(@RequestBody CheckoutCustomer request){
        return add.checkOut(request);
    }

    @PutMapping("/StaffCheckout")
    public Invoice checkOut(@RequestBody CheckoutStaff request){
        return add.checkOut(request);
    }

}
