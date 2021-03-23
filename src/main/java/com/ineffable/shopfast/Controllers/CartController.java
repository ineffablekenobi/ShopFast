package com.ineffable.shopfast.Controllers;

import com.ineffable.shopfast.Dto.RemoveFromCartRequest;
import com.ineffable.shopfast.Dto.addToCartRequest;
import com.ineffable.shopfast.Models.Shop.Cart;
import com.ineffable.shopfast.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Cart getCart(@PathVariable("userdid")Long userid){
        return add.getCart(userid);
    }

}
