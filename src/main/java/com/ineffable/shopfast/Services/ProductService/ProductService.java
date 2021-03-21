package com.ineffable.shopfast.Services.ProductService;

import com.ineffable.shopfast.Models.Products.Products;
import com.ineffable.shopfast.Models.Products.TeeShirt;
import com.ineffable.shopfast.Repository.ProductRepo.TeeShirtRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private TeeShirtRepo teeShirtRepo;

    public Products getProductById(Long id){
        Optional<TeeShirt> tee = teeShirtRepo.findById(id);
        if(tee.isPresent()){
            return tee.get();
        }
        return new Products("Unknown Product");
    }

    public List<Products> getProducts() {
        List<Products> list = new ArrayList<>();
        teeShirtRepo.findAll().forEach(list::add);
        return list;
    }

    public List<TeeShirt> getALLTeeShirts() {
        List<TeeShirt> list = new ArrayList<>();
        teeShirtRepo.findAll().forEach(list::add);
        return list;
    }

}
