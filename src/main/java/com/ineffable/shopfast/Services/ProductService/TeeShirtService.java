package com.ineffable.shopfast.Services.ProductService;

import com.ineffable.shopfast.Models.Products.Products;
import com.ineffable.shopfast.Models.Products.TeeShirt;
import com.ineffable.shopfast.Models.Shop.Shop;
import com.ineffable.shopfast.Repository.ProductRepo.TeeShirtRepo;
import com.ineffable.shopfast.Repository.ShopRepo.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeeShirtService {

    @Autowired
    private TeeShirtRepo teeShirtRepo;

    @Autowired
    private ShopRepo shopRepo;

    public void createProduct(TeeShirt teeShirt) {
        Shop shop = shopRepo.findById(teeShirt.getShopId()).get();
        teeShirtRepo.save(teeShirt);
        shop.products.add((Products) teeShirt);
        shopRepo.save(shop);
    }



}
