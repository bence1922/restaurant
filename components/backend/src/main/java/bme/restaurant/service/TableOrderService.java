package bme.restaurant.service;

import org.springframework.stereotype.Component;

import bme.restaurant.dto.TableOrderDTO;

@Component
public interface TableOrderService {
    TableOrderDTO findTableOrder(Integer tableNumber);
}
