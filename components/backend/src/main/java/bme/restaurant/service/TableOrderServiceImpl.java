package bme.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bme.restaurant.dao.TableOrder;
import bme.restaurant.dto.DrinkDTO;
import bme.restaurant.dto.DrinkOrderItemDTO;
import bme.restaurant.dto.FoodDTO;
import bme.restaurant.dto.FoodOrderItemDTO;
import bme.restaurant.dto.FoodRecipeInnerDTO;
import bme.restaurant.dto.FoodRecipeInnerDTO.UnitEnum;
import bme.restaurant.dto.OrderDTO;
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
