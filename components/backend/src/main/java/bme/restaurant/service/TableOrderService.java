package bme.restaurant.service;

import org.springframework.stereotype.Component;

import bme.restaurant.dto.OrderDTO;

@Component
public interface TableOrderService {
    OrderDTO findTableOrder(Integer tableNumber);
}
