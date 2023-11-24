package bme.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bme.restaurant.dto.TableOrderDTO;
import bme.restaurant.repository.TableOrderRepository;
import bme.restaurant.repository.TableRepository;

@Service
public class TableOrderServiceImpl implements TableOrderService {

    @Autowired
    private TableRepository tableRepo;

    @Autowired
    private TableOrderRepository tableOrderRepo;

    @Override
    public TableOrderDTO findTableOrder(Integer tableNumber) {
        var table = tableRepo.findByNumber(tableNumber);
        var response = tableOrderRepo.findByTable(table);
        return response.toDTO();
    }
}
