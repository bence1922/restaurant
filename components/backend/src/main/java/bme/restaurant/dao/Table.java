package bme.restaurant.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import bme.restaurant.dto.TableDTO;
import bme.restaurant.dto.TableDTO.StatusEnum;

@Document(collection = "tables")
public class Table {
    @Id
    private String id;

    private int number;

    private int capacity;

    private String status;

    public Table(
            int number,
            int capacity,
            String status) {
        super();  
        this.number = number;
        this.capacity = capacity;
        this.status = status;
    }

    public Table() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TableDTO toDTO(){
        var dto = new TableDTO(
            number,
            capacity
        );
        dto.setStatus(StatusEnum.fromValue(status));
        return dto;
    }

    public static Table fromDTO(TableDTO dto){
        return new Table(
            dto.getNumber(),
            dto.getCapacity(),
            dto.getStatus().getValue()
        );
    }
}
