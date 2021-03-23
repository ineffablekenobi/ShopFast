package com.ineffable.shopfast.Services.UserService;

import com.ineffable.shopfast.Models.Users.Customer;
import com.ineffable.shopfast.Models.Users.Staff;
import com.ineffable.shopfast.Models.Users.User;
import com.ineffable.shopfast.Repository.ShopRepo.StaffRepo;
import com.ineffable.shopfast.Repository.UserRepo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private StaffRepo staffRepo;

    public User getUserByUsername(String name) {
        Optional<Customer> customer = customerRepo.findByUsername(name);
        Optional<Staff> stuff = staffRepo.findByUsername(name);
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
        Optional<Staff> stuff = staffRepo.findByEmail(email);
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
        Optional<Staff> stuff = staffRepo.findById(id);
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
        Optional<Staff> stuff = staffRepo.findById(id);
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
        Optional<Staff> stuff = staffRepo.findById(id);
        if(customer.isPresent()){
            Customer cst = customer.get();
            cst.setActive(!cst.isActive());
            customerRepo.save(cst);
        }else if(stuff.isPresent()){
            Staff stf = stuff.get();
            stf.setActive(!stf.isActive());
            staffRepo.save(stf);
        }
    }

}
