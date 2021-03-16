package com.ineffable.shopfast.Services;

import com.ineffable.shopfast.Models.Users.Customer;
import com.ineffable.shopfast.Models.Users.User;
import com.ineffable.shopfast.Repository.CustomerRepo;
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

    public void createCustomer(Customer customer) {
        customerRepo.save(customer);
    }


    public Optional<Customer> getCustomer(long id) {
        Optional<Customer> customer = customerRepo.findById(id);
        return customer;
    }
}
