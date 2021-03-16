package com.ineffable.shopfast.Controllers.UserController;

import com.ineffable.shopfast.Models.Users.User;
import com.ineffable.shopfast.Services.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/findUser/username/{name}")
    public User getUserByName(@PathVariable("name") String name){
        return userService.getUserByUsername(name);
    }

    @GetMapping("/findUser/email/{email}")
    public User getUserByEmail(@PathVariable("email") String email){
        return userService.gerUserByEmail(email);
    }


}
