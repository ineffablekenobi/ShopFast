package com.ineffable.shopfast.Controllers.UserController;

import com.ineffable.shopfast.Models.Users.Customer;
import com.ineffable.shopfast.Models.Users.User;
import com.ineffable.shopfast.Services.UserService.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    // use this to create any new customer
    @PostMapping("/createCustomer")
    public void createCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }

    // use this to get a list of all availaable customer
    @GetMapping("/getCustomer")
    public List<Customer> getAllUser(){
        return customerService.getAllCustomers();
    }

}
