package bme.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bme.restaurant.api.TableOrderApi;
import bme.restaurant.dto.TableOrderDTO;
import bme.restaurant.service.TableOrderService;

@RestController
public class TableOrderController implements TableOrderApi {

    @Autowired
    TableOrderService tableOrderService;

    @Override
    public ResponseEntity<TableOrderDTO> findTableOrder(Integer tableNumber) {
        var response = tableOrderService.findTableOrder(tableNumber);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
