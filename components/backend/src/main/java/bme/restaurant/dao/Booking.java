package bme.restaurant.dao;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import bme.restaurant.dto.BookingDTO;
import bme.restaurant.dto.BookingDTO.StatusEnum;

@Document(collection = "bookings")
public class Booking {
    @Id
    private String id;

    @DocumentReference
    private Table table;

    @DocumentReference
    private User customer;

    private LocalDateTime start;

    private LocalDateTime end;

    private String status;

    private int peopleCount;

    public Booking(
            Table table,
            User customer,
            LocalDateTime start,
            LocalDateTime end,
            String status,
            int peopleCount) {
        super();  
        this.table = table;
        this.customer = customer;
        this.start = start;
        this.end = end;
        this.status = status;
        this.peopleCount = peopleCount;
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

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public BookingDTO toDTO() {
        return new BookingDTO(
            id,
            table.toDTO(),
            customer.toDTO(),
            start.atZone(ZoneId.of("Europe/Budapest")).toOffsetDateTime(),
            end.atZone(ZoneId.of("Europe/Budapest")).toOffsetDateTime(),
            StatusEnum.fromValue(status),
            peopleCount
        );
    }
}
