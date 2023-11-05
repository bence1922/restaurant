package bme.restaurant.service;

import org.springframework.stereotype.Component;

import bme.restaurant.dto.OrderDTO;

@Component
public interface TableOrderService {
    public OrderDTO findTableOrder(Integer tableNumber);
}
