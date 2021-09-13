package com.example.ecommerce.service;

import com.example.ecommerce.entity.LineItem;
import com.example.ecommerce.entity.Order;

import javax.validation.constraints.NotNull;

public interface LineItemService {
    @NotNull(message = "The products for order cannot be null.")
    LineItem create(LineItem lineItem);
}
