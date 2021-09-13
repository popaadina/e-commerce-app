package com.example.ecommerce.service.impl;

import com.example.ecommerce.entity.LineItem;

import com.example.ecommerce.repository.LineItemRepository;
import com.example.ecommerce.service.LineItemService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LineItemServiceImpl implements LineItemService {
    @Autowired
    private LineItemRepository lineItemRepository;

    @Override
    public LineItem create(LineItem lineItem) {
        return this.lineItemRepository.save(lineItem);
    }
}
