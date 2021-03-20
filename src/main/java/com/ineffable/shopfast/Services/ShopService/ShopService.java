package com.ineffable.shopfast.Services.ShopService;

import com.ineffable.shopfast.Models.Shop.Shop;
import com.ineffable.shopfast.Repository.ShopRepo.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopService {
    @Autowired
    private ShopRepo shopRepo;

    public Long createShop(Shop shop) {
        return shopRepo.save(shop).getId();
    }

    public List<Shop> getAllShop() {
        List<Shop> list = new ArrayList<>();
        shopRepo.findAll().forEach(list::add);
        return list;
    }

    public Shop findById(Long id) {
        Optional<Shop> shop = shopRepo.findById(id);
        return shop.orElseGet(() -> new Shop("Unknown Shop"));
    }
}
