package com.ineffable.shopfast.Controllers.ShopController;

import com.ineffable.shopfast.Models.Shop.Shop;
import com.ineffable.shopfast.Services.ShopService.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopController {
    @Autowired
    private ShopService shopService;

    // use this to create a new shop
    @PostMapping("/createShop")
    public Long createCustomer(@RequestBody Shop shop){
        return shopService.createShop(shop);
    }

    // use this to get all available shop
    @GetMapping("/getShop")
    public List<Shop> getAllShop(){
        return shopService.getAllShop();
    }

    //use this to get any shop by their id
    @GetMapping("/getShop/{id}")
    public Shop getShop(@PathVariable("id") Long id){
        return shopService.findById(id);
    }
}
