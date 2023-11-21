package bme.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bme.restaurant.api.TableApi;
import bme.restaurant.dto.TableDTO;
import bme.restaurant.service.TableService;

@RestController
public class TableController implements TableApi {

    @Autowired
    TableService tableService;

    @Override
    public ResponseEntity<List<TableDTO>> listTables() {
        var response = tableService.listTables();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<TableDTO> findTable(Integer tableNumber) {
        var response = tableService.findTable(tableNumber);
        if (response != null){        
            return ResponseEntity.ok(response);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<TableDTO> patchTable(Integer tableNumber, Integer capacity) {
        var response = tableService.createOrUpdateTable(tableNumber, capacity);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> deleteTable(Integer tableNumber) {
        tableService.deleteTable(tableNumber);
        return ResponseEntity.ok().build();
    }
}
