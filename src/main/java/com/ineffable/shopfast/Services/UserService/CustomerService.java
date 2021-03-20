package com.ineffable.shopfast.Services.UserService;

import com.ineffable.shopfast.Models.Users.Customer;
import com.ineffable.shopfast.Repository.UserRepo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    public List<Customer> getAllCustomers(){
        List<Customer> list = new ArrayList<>();
        Iterator<Customer> itr = customerRepo.findAll().iterator();
        while (itr.hasNext()){
            list.add(itr.next());
        }
        return list;
    }

    public Long createCustomer(Customer customer) {
        return customerRepo.save(customer).getId();
    }


    public Optional<Customer> getCustomer(long id) {
        Optional<Customer> customer = customerRepo.findById(id);
        return customer;
    }


    public boolean getStatus(Long id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if(customer.isPresent()){
            return customer.get().isActive();
        }else{
            return false;
        }
    }

    public void setStatus(Long id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if(customer.isPresent()){
            Customer cst = customer.get();
            cst.setActive(!cst.isActive());
            customerRepo.save(cst);
        }
    }


}
