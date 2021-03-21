package com.ineffable.shopfast.Controllers.ShopController;
import com.ineffable.shopfast.Models.Users.Staff;
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

    // call this to create a new Stuff
    @PostMapping("/createStuff")
    public Long createStuff(@RequestBody Staff staff){
        return stuffService.createStuff(staff);
    }


    // call this to get all available stuffs
    @GetMapping("/getStuff")
    public List<Staff> getAllStuff(){
        return stuffService.getAllStuff();
    }


}
