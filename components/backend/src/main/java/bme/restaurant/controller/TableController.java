package bme.restaurant.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import bme.restaurant.api.TableApi;
import bme.restaurant.auth.Authorize;
import bme.restaurant.dto.OrderDTO;
import bme.restaurant.dto.TableDTO;
import bme.restaurant.dto.TableOrderDTO;
import bme.restaurant.service.OrderService;
import bme.restaurant.service.TableService;
import jakarta.validation.Valid;

@RestController
public class TableController implements TableApi {
    @Autowired
    TableService tableService;

    @Autowired
    OrderService orderService;

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
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
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

    @Override
    @Authorize(permission = "table-order-read")
    public ResponseEntity<List<TableOrderDTO>> queryTableOrders(Integer tableNumber, Boolean isCurrent) {
        var response = orderService.queryTableOrders(tableNumber, isCurrent);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    @Authorize(permission = "table-order-write")
    public ResponseEntity<TableOrderDTO> placeTableOrder(Integer tableNumber, @Valid OrderDTO orderDTO) {
        var response = orderService.createTableOrder(tableNumber, orderDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
