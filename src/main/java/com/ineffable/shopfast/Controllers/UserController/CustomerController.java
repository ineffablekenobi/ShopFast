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

    @PostMapping("/createCustomer")
    public void createCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }


    @GetMapping("/getCustomer")
    public List<Customer> getAllUser(){
        return customerService.getAllCustomers();
    }


    @GetMapping("/getCustomer/{id}")
    public Customer getCustomer(@PathVariable("id") Long id){

        Optional<Customer> customer = customerService.getCustomer(id);
        return customer.orElseGet(() -> new Customer("Unknown User"));
    }

    @GetMapping("/Customer/status/{id}")
    public boolean getStatus(@PathVariable("id") Long id){
        return customerService.getStatus(id);
    }



    @PutMapping("/Customer/status/{id}")
    public void setStatus(@PathVariable("id") Long id){
        customerService.setStatus(id);
    }

}
