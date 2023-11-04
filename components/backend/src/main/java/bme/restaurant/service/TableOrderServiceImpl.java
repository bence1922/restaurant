package bme.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bme.restaurant.repository.TableOrderRepository;
import bme.restaurant.dto.Order;

@Service
public class TableOrderServiceImpl implements TableOrderService {

    @Autowired
    TableOrderRepository tableRepo;

    @Override
    public Order findTableOrder(Integer tableNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findTableOrder'");
    }

    
}
