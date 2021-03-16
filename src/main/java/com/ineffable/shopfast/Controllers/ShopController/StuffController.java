package com.ineffable.shopfast.Controllers.ShopController;

import com.ineffable.shopfast.Models.Users.Customer;
import com.ineffable.shopfast.Models.Users.Stuff;
import com.ineffable.shopfast.Services.ShopService.StuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StuffController{

    @Autowired
    private StuffService stuffService;

    @PostMapping("/createStuff")
    public void createStuff(@RequestBody Stuff stuff){
        stuffService.createStuff(stuff);
    }


    @GetMapping("/getStuff")
    public List<Stuff> getAllStuff(){
        return stuffService.getAllStuff();
    }


}
