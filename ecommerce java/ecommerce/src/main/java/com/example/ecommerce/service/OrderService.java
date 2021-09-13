package com.example.ecommerce.service;

import com.example.ecommerce.entity.LineItem;
import com.example.ecommerce.entity.Order;
import com.example.ecommerce.entity.Product;


import java.util.List;
import java.util.Optional;


public interface OrderService {
    public List<LineItem> getAllItemsFromOrder();



    void create(Product product);



    Optional<Order> findById(long id);


    void deleteLineItem(LineItem lineItem);
}


