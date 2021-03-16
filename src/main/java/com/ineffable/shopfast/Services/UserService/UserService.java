package com.ineffable.shopfast.Services.UserService;

import com.ineffable.shopfast.Models.Products;
import com.ineffable.shopfast.Models.Users.Customer;
import com.ineffable.shopfast.Models.Users.Stuff;
import com.ineffable.shopfast.Models.Users.User;
import com.ineffable.shopfast.Repository.ShopRepo.StuffRepo;
import com.ineffable.shopfast.Repository.UserRepo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.codec.CodecCustomizer;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private StuffRepo stuffRepo;

    public User getUserByUsername(String name) {
        Optional<Customer> customer = customerRepo.findByUsername(name);
        Optional<Stuff> stuff = stuffRepo.findByUsername(name);
        if(customer.isPresent()){
            return customer.get();
        }else if(stuff.isPresent()){
            return stuff.get();
        }{
            return new Customer("Unknown User");
        }
    }

    public User gerUserByEmail(String email){
        Optional<Customer> customer = customerRepo.findByEmail(email);
        Optional<Stuff> stuff = stuffRepo.findByEmail(email);
        if(customer.isPresent()){
            return customer.get();
        }else if(stuff.isPresent()){
            return stuff.get();
        }{
            return new Customer("Unknown User");
        }
    }

    public User getUserByID(Long id) {
        Optional<Customer> customer = customerRepo.findById(id);
        Optional<Stuff> stuff = stuffRepo.findById(id);
        if(customer.isPresent()){
            return customer.get();
        }else if(stuff.isPresent()){
            return stuff.get();
        }else{
            return new User("Unknown User");
        }
    }

    public boolean getStatus(Long id) {
        Optional<Customer> customer = customerRepo.findById(id);
        Optional<Stuff> stuff = stuffRepo.findById(id);
        if(customer.isPresent()){
            return customer.get().isActive();
        }else if(stuff.isPresent()){
            return stuff.get().isActive();
        }{
            return false;
        }
    }

    public void setStatus(Long id) {
        Optional<Customer> customer = customerRepo.findById(id);
        Optional<Stuff> stuff = stuffRepo.findById(id);
        if(customer.isPresent()){
            Customer cst = customer.get();
            cst.setActive(!cst.isActive());
            customerRepo.save(cst);
        }else if(stuff.isPresent()){
            Stuff stf = stuff.get();
            stf.setActive(!stf.isActive());
            stuffRepo.save(stf);
        }
    }

}
