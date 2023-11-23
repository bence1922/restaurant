package bme.restaurant.controller;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bme.restaurant.api.CustomerApi;
import bme.restaurant.dto.BookingDTO;
import bme.restaurant.service.BookingServiceImpl;

@RestController
public class CustomerController implements CustomerApi {
    @Autowired
    private BookingServiceImpl bookingService;

    @Override
    public ResponseEntity<List<BookingDTO>> queryCustomerBookings(
            String customerId,
            OffsetDateTime from,
            OffsetDateTime to) {
        var response = bookingService.queryCustomerBookings(customerId, from, to);
        return ResponseEntity.ok(response);
    }
}
