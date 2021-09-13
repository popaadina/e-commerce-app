package com.example.ecommerce.service.impl;

import com.example.ecommerce.entity.Product;

import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;



    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(long id) {
        return productRepository
                .findById(id);


    }

    @Override
    public Product save(Product prd) {
        return productRepository.save(prd);
    }

    @Override
    public Product getProduct(Long id) {
        return null;
    }
}
