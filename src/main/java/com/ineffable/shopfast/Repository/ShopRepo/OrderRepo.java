package com.ineffable.shopfast.Repository.ShopRepo;

import com.ineffable.shopfast.Models.Shop.Orders;
import com.ineffable.shopfast.Models.Users.Staff;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrderRepo extends CrudRepository<Orders,Long> {
    public Optional<Orders> findByProductId(Long productId);
}
