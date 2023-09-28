package bme.restaurant.Bll.services;

import org.springframework.stereotype.Service;

import bme.restaurant.Bll.dtos.TableDto;

@Service
public class TableServiceImpl implements TableService {

    @Override
    public TableDto getTable(int number) {
        return new TableDto(number);
    }
    
}
