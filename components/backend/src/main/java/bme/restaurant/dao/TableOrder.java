package bme.restaurant.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import bme.restaurant.dto.TableOrderDTO;

@Document(collection = "table_orders")
public class TableOrder {
    @Id
    private String id;

    @DocumentReference
    private Table table;

    private Order order;

    public TableOrder(
            Table table,
            Order order) {
        super();  
        this.table = table;
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public TableOrderDTO toDTO(){
        var dto = new TableOrderDTO();
        dto.setTable(table.toDTO());
        dto.setOrder(order.toDTO());
        return dto;
    }
}
