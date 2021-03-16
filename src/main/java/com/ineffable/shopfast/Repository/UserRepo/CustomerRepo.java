package com.ineffable.shopfast.Repository.UserRepo;

import com.ineffable.shopfast.Models.Users.Customer;
import com.ineffable.shopfast.Models.Users.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepo extends CrudRepository<Customer,Long> {
    public Optional<Customer> findByUsername(String username);
    public Optional<Customer> findByEmail(String email);
}
