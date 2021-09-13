package com.example.ecommerce.controller;

import com.example.ecommerce.entity.LineItem;
import com.example.ecommerce.entity.Order;


import com.example.ecommerce.entity.Product;
import com.example.ecommerce.exception.OrderNotFoundException;

import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.sound.sampled.Line;
import javax.validation.constraints.Min;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin("http://localhost:3000")
public class OrderController {
    @Autowired
    private OrderService orderService;



    @GetMapping
    ResponseEntity<List<LineItem>> getAll() {
        return ResponseEntity.ok(this.orderService.getAllItemsFromOrder());
    }

    @GetMapping(value="/{id}")
    ResponseEntity<Order> getById(@PathVariable("id") @Min(1) long id) {
        System.out.println(id);
        Order ord = orderService.findById(id)
                .orElseThrow(()->new OrderNotFoundException("No Order with ID : "+id));
        return ResponseEntity.ok().body(ord);
    }



    @DeleteMapping
    ResponseEntity<String> deleteLineItem(@RequestBody LineItem lineItem){
        this.orderService.deleteLineItem(lineItem);
        return ResponseEntity.ok(lineItem.getName() + "was deleted");
    }

    @PostMapping
    public ResponseEntity<String> createOrderOrAddProduct(@RequestBody Product product){
        System.out.println(product.toString());
        this.orderService.create(product);
        return ResponseEntity.ok("Created");
    }

}
