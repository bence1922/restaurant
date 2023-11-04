package bme.restaurant.service;

import org.springframework.stereotype.Component;

import bme.restaurant.dto.Order;

@Component
public interface TableOrderService {
    public Order findTableOrder(Integer tableNumber);
}
