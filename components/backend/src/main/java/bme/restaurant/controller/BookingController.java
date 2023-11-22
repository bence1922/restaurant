package bme.restaurant.controller;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bme.restaurant.api.BookingApi;
import bme.restaurant.dto.BookingDTO;
import bme.restaurant.dto.NewBookingDTO;
import bme.restaurant.dto.TableDTO;
import bme.restaurant.service.BookingServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
public class BookingController implements BookingApi {

    @Autowired
    private BookingServiceImpl bookingService;

    @Override
    public ResponseEntity<BookingDTO> getBooking(String id) {
        var response = bookingService.getBooking(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<BookingDTO> bookTable(@Valid NewBookingDTO newBookingDTO) {
        var response = bookingService.bookTable(newBookingDTO);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<BookingDTO> bookingStatusUpdate(String id, @NotNull String status) {
        var response = bookingService.bookingStatusUpdate(id, status);
        return ResponseEntity.ok(response);
    }
    
    @Override
    public ResponseEntity<List<BookingDTO>> queryBookings(
        Integer tableNumber, 
        String customerName, 
        OffsetDateTime from,
        OffsetDateTime to) {
        var response = bookingService.queryBookings(tableNumber, customerName, from, to);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<BookingDTO>> queryCustomerBookings(String customerId, OffsetDateTime from,
            OffsetDateTime to) {
        var response = bookingService.queryCustomerBookings(customerId, from, to);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<TableDTO>> queryTablesForBooking(OffsetDateTime from, OffsetDateTime to) {
        var response = bookingService.queryTablesForBooking(from, to);
        return ResponseEntity.ok(response);
    }
}
