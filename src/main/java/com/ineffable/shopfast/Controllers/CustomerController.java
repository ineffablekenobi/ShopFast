package com.ineffable.shopfast.Controllers;

import com.ineffable.shopfast.Models.Users.Customer;
import com.ineffable.shopfast.Models.Users.User;
import com.ineffable.shopfast.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/createCustomer")
    public void createCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }


    @GetMapping("/getUser")
    public List<Customer> getAllUser(){
        return customerService.getAllCustomers();
    }

}
