package com.ineffable.shopfast.Repository.SalesRepo;

import com.ineffable.shopfast.Models.Shop.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepo extends CrudRepository<Orders, Long> {

}
