package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.exception.ProductNotFoundException;
import com.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins="http://localhost:3000")
public class ProductController {

    @Autowired
    public ProductService productService;

    @GetMapping
    List<Product> getAll() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product){
        return ResponseEntity.ok(productService.save(product));
    }
    @GetMapping(value="/{id}")
    ResponseEntity<Product> getById(@PathVariable("id") @Min(1) long id) {
        System.out.println(id);
        Product prd = productService.findById(id)
                .orElseThrow(()->new ProductNotFoundException("No Product with ID : "+id));
        return ResponseEntity.ok().body(prd);
    }

}

