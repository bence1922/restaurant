package bme.restaurant.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import bme.restaurant.dao.Table;
import bme.restaurant.dto.TableDTO;
import bme.restaurant.repository.TableRepository;

@Service
public class TableServiceImpl implements TableService {

    @Autowired
    private TableRepository tableRepo;

    @Override
    public List<TableDTO> listTables() {
        return tableRepo.findAll().stream()
            .map(table -> table.toDTO())
            .collect(Collectors.toList());
    }

    @Override
    public TableDTO findTable(int number) {
        var entity = tableRepo.findByNumber(number);
        if (entity == null) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,
                    String.format("Table not found with number: %s", number)); 
        }
        return entity.toDTO();
    }

    @Override
    public TableDTO createOrUpdateTable(int number, int capacity) {
        var entity = tableRepo.findByNumber(number);
        if (entity == null) {
            entity = new Table();
            entity.setNumber(number);
            entity.setCapacity(capacity);
            entity.setStatus("free");
            tableRepo.insert(entity);
        }
        else {
            entity.setCapacity(capacity);
            tableRepo.save(entity);
        }
        return entity.toDTO();
    }

    @Override
    public void deleteTable(int number) {
        tableRepo.deleteByNumber(number);
    }
}
