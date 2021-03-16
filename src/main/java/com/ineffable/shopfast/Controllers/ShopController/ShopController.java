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

    @PostMapping("/createShop")
    public void createCustomer(@RequestBody Shop shop){
        shopService.createShop(shop);
    }

    @GetMapping("/getShop")
    public List<Shop> getAllShop(){
        return shopService.getAllShop();
    }

    @GetMapping("/getShop/{id}")
    public Shop getShop(@PathVariable("id") Long id){
        return shopService.findById(id);
    }
}
