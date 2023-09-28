package bme.restaurant.Bll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bme.restaurant.Bll.dtos.TableDto;
import bme.restaurant.Dal.repositories.TableRepository;

@Service
public class TableServiceImpl implements TableService {

    @Autowired
    TableRepository tableRepo;

    @Override
    public TableDto getTable(int number) {
        var table = tableRepo.findTableByNumber(number);
        return new TableDto(table.getNumber());
    }
    
}
