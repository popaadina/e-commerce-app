package com.example.ecommerce.service.impl;

import com.example.ecommerce.entity.LineItem;
import com.example.ecommerce.entity.Order;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.LineItemRepository;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private LineItemRepository lineItemRepository;
    @Autowired
    private ProductRepository productRepository;



    @Override
    public void create(Product product) {
        Order order = this.orderRepository.getById(14L);
        LineItem lineItem = new LineItem();
        lineItem.setName(product.getName());
        lineItem.setPrice(product.getPrice());
        lineItem.setOrder(order);
        lineItem.setProduct(this.productRepository.getById(product.getId()));
        order.getLineItems().add(lineItem);
        this.lineItemRepository.save(lineItem);
        this.orderRepository.save(order);

    }

    @Override
    public List<LineItem> getAllItemsFromOrder() {
        return this.orderRepository.getById(14L).getLineItems();
    }



    @Override
    public Optional<Order> findById(long id) {
        return orderRepository
                .findById(id);
    }


    @Override
    public void deleteLineItem(LineItem lineItem) {
        this.lineItemRepository.delete(lineItem);
    }
}
