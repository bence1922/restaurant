package bme.restaurant.Api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import bme.restaurant.Bll.dtos.TableDto;
import bme.restaurant.Bll.services.TableService;
import bme.restaurant.Bll.services.TableServiceImpl;

@RestController
public class TableController {
    
    @Autowired
    private TableService tableService;

    public TableController() {
        this.tableService = new TableServiceImpl();
    }

    @GetMapping("table/{number}")
    public ResponseEntity<TableDto> getTable(@PathVariable("number") int number){
        var table = tableService.getTable(number);

        return ResponseEntity.status(HttpStatus.OK).body(table);
    }
}
