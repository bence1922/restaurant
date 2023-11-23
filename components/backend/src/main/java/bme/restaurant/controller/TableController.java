package bme.restaurant.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import bme.restaurant.api.TableApi;
import bme.restaurant.auth.Authorize;
import bme.restaurant.dto.TableDTO;
import bme.restaurant.service.TableService;

@RestController
public class TableController implements TableApi {
    @Autowired
    TableService tableService;

    @Override
    @Authorize(permission = "table-read")
    public ResponseEntity<List<TableDTO>> listTables() {
        var response = tableService.listTables();
        return ResponseEntity.ok(response);
    }

    @Override
    @Authorize(permission = "table-read")
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
    @Authorize(permission = "table-write")
    public ResponseEntity<TableDTO> patchTable(Integer tableNumber, Integer capacity) {
        var response = tableService.createOrUpdateTable(tableNumber, capacity);
        return ResponseEntity.ok(response);
    }

    @Override
    @Authorize(permission = "table-delete")
    public ResponseEntity<Void> deleteTable(Integer tableNumber) {
        tableService.deleteTable(tableNumber);
        return ResponseEntity.ok().build();
    }
}
