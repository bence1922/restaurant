package bme.restaurant.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bme.restaurant.api.TableOrderApi;
import bme.restaurant.dto.Order;

@RestController
public class TableOrderController implements TableOrderApi {
    @Override
    public ResponseEntity<Order> findTableOrder(Integer tableNumber) {
        
        return TableOrderApi.super.findTableOrder(tableNumber);
    }
}
