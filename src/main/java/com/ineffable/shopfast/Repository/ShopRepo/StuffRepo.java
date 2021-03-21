package com.ineffable.shopfast.Repository.ShopRepo;

import com.ineffable.shopfast.Models.Users.Staff;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StuffRepo extends CrudRepository<Staff,Long> {
    public Optional<Staff> findByUsername(String username);
    public Optional<Staff> findByEmail(String email);
}
