package com.ineffable.shopfast.Services.UserService;

import com.ineffable.shopfast.Models.Users.Customer;
import com.ineffable.shopfast.Models.Users.User;
import com.ineffable.shopfast.Repository.UserRepo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.codec.CodecCustomizer;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private CustomerRepo customerRepo;

    public User getUserByUsername(String name) {
        Optional<Customer> customer = customerRepo.findByUsername(name);

        if(customer.isPresent()){
            return customer.get();
        }else{
            return new Customer("Unknown User");
        }
    }

    public User gerUserByEmail(String email){
        Optional<Customer> customer = customerRepo.findByEmail(email);
        if(customer.isPresent()){
            return customer.get();
        }else{
            return new Customer("Unknown User");
        }
    }

}
