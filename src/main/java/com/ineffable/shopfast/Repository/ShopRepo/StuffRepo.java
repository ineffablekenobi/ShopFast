package com.ineffable.shopfast.Repository.ShopRepo;

import com.ineffable.shopfast.Models.Users.Customer;
import com.ineffable.shopfast.Models.Users.Stuff;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StuffRepo extends CrudRepository<Stuff,Long> {
    public Optional<Stuff> findByUsername(String username);
    public Optional<Stuff> findByEmail(String email);
}
