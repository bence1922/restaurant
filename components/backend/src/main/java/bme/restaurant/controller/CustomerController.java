package bme.restaurant.controller;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bme.restaurant.api.CustomerApi;
import bme.restaurant.auth.Authorize;
import bme.restaurant.dto.BookingDTO;
import bme.restaurant.dto.UserDTO;
import bme.restaurant.dto.UserRegisterDTO;
import bme.restaurant.service.BookingServiceImpl;
import bme.restaurant.service.UserServiceImpl;
import jakarta.validation.Valid;

@RestController
public class CustomerController implements CustomerApi {
    @Autowired
    private BookingServiceImpl bookingService;
    
    @Autowired
    private UserServiceImpl userService;
    
    @Override
    @Authorize(permission = "customer-list")
    public ResponseEntity<List<UserDTO>> listCustomers() {
        List<UserDTO> customers = userService.getCustomers();
        return ResponseEntity.ok(customers);
    }

    @Override
    public ResponseEntity<UserDTO> registerCustomer(@Valid UserRegisterDTO userRegisterDTO) {
        UserDTO user = userService.registerCustomer(userRegisterDTO);
        return ResponseEntity.ok(user);
    } 

    @Override
    public ResponseEntity<List<BookingDTO>> queryCustomerBookings(
            String customerId,
            OffsetDateTime from,
            OffsetDateTime to) {
        var response = bookingService.queryCustomerBookings(customerId, from, to);
        return ResponseEntity.ok(response);
    }
}
