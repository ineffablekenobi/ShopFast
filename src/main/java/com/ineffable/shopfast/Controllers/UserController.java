package com.ineffable.shopfast.Controllers;

import com.ineffable.shopfast.Entities.User;
import com.ineffable.shopfast.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
       public void createUser(@RequestBody User user){
            userService.createUser(user);
        }


        @GetMapping("/getUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

}
