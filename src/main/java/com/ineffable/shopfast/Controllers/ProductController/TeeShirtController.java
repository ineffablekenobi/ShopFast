package com.ineffable.shopfast.Controllers.ProductController;

import com.ineffable.shopfast.Models.Products.Products;
import com.ineffable.shopfast.Models.Products.TeeShirt;
import com.ineffable.shopfast.Services.ProductService.TeeShirtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeeShirtController {
    @Autowired
    private TeeShirtService teeShirtService;

    //use it to create a new product
    @PostMapping("/createTeeShirt")
    public Long createProduct(@RequestBody TeeShirt teeShirt){
        return teeShirtService.createProduct(teeShirt);
    }



}
