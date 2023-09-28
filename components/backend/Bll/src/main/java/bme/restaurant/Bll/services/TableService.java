package bme.restaurant.Bll.services;

import org.springframework.stereotype.Component;

import bme.restaurant.Bll.dtos.TableDto;

@Component
public interface TableService {
    TableDto getTable(int number);
}
