package com.ineffable.shopfast.Services.ProductService;

import com.ineffable.shopfast.Models.Products.Products;
import com.ineffable.shopfast.Models.Products.TeeShirt;
import com.ineffable.shopfast.Repository.ProductRepo.TeeShirtRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeeShirtService {

    @Autowired
    private TeeShirtRepo teeShirtRepo;




    public Long createProduct(TeeShirt teeShirt) {
        return teeShirtRepo.save(teeShirt).getId();
    }



}
