package com.ineffable.shopfast.Controllers.UserController;

import com.ineffable.shopfast.Models.Users.User;
import com.ineffable.shopfast.Services.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /*
    User is both a stuff and a customer.
    So the methods below are applicable for all kinds of users.
    */

    //use this to find any user by their username
    @GetMapping("/findUser/username/{name}")
    public User getUserByName(@PathVariable("name") String name){
        return userService.getUserByUsername(name);
    }

    //use this to find any user by their email
    @GetMapping("/findUser/email/{email}")
    public User getUserByEmail(@PathVariable("email") String email){
        return userService.gerUserByEmail(email);
    }

    //use this to find any user by their id
    @GetMapping("/findUser/{id}")
    public User getUserByID(@PathVariable("id") Long id){return userService.getUserByID(id);}

    //use this to find any user's user status
    @GetMapping("/User/status/{id}")
    public boolean getStatus(@PathVariable("id") Long id){
        return userService.getStatus(id);
    }

    //use this to set any user's user status
    @PutMapping("/User/status/{id}")
    public void setStatus(@PathVariable("id") Long id){
        userService.setStatus(id);
    }


}
