package com.ineffable.shopfast.Controllers.ProductController;

import com.ineffable.shopfast.Models.Products.Products;
import com.ineffable.shopfast.Models.Products.TeeShirt;
import com.ineffable.shopfast.Services.ProductService.ProductService;
import com.ineffable.shopfast.Services.ProductService.TeeShirtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    //find a product by id
    @GetMapping("/findProduct/{id}")
    public Products getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }


    //find all teeShirts
    @GetMapping("/getTeeShirt")
    public List<TeeShirt> getTeeShirts(){
        return productService.getALLTeeShirts();
    }
}
