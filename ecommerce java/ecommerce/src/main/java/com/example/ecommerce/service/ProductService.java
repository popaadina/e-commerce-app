package com.example.ecommerce.service;

import com.example.ecommerce.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> findById(long id);
    Product save(Product prd);

    Product getProduct(Long id);
}
