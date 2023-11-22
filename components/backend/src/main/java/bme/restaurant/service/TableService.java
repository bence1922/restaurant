package bme.restaurant.service;

import java.util.List;

import bme.restaurant.dto.TableDTO;

public interface TableService {
    List<TableDTO> listTables();
    TableDTO findTable(int number);
    TableDTO createOrUpdateTable(int number, int capacity);
    void deleteTable(int number);
}
