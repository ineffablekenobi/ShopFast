package com.ineffable.shopfast.Controllers;

import com.ineffable.shopfast.Dto.addToCartRequest;
import com.ineffable.shopfast.Models.Shop.Cart;
import com.ineffable.shopfast.Services.addToCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class addToCartController {

    @Autowired
    private addToCartService add;

    @PutMapping("/addToCart")
    public Cart addToCart(@RequestBody addToCartRequest request){
        return add.addToCart(request);
    }

}
