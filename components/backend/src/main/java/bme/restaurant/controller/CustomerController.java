package bme.restaurant.controller;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bme.restaurant.api.CustomerApi;
import bme.restaurant.auth.Authorize;
import bme.restaurant.dto.BookingDTO;
import bme.restaurant.dto.CustomerOrderDTO;
import bme.restaurant.dto.OrderDTO;
import bme.restaurant.dto.UserDTO;
import bme.restaurant.dto.UserRegisterDTO;
import bme.restaurant.service.BookingService;
import bme.restaurant.service.OrderService;
import bme.restaurant.service.UserService;
import jakarta.validation.OverridesAttribute;
import jakarta.validation.Valid;

@RestController
public class CustomerController implements CustomerApi {
    @Autowired
    private UserService userService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private OrderService orderService;

    @Override
    public ResponseEntity<UserDTO> registerCustomer(@Valid UserRegisterDTO userRegisterDTO) {
        var response = userService.registerCustomer(userRegisterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    @Authorize(permission = "customer-read")
    public ResponseEntity<List<UserDTO>> listCustomers() {
        var response = userService.getCustomers();
        return ResponseEntity.ok(response);
    }

    @Override
    @Authorize(permission = "customer-order-read")
    public ResponseEntity<List<CustomerOrderDTO>> queryCustomerOrders(String customerName, Boolean isCurrent) {
        var response = orderService.queryCustomerOrders(customerName, isCurrent);
        return ResponseEntity.ok(response);
    }

    @Override
    @Authorize(permission = "customer-order-write", selfAccess = true, roles = {"admin", "employee"})
    public ResponseEntity<OrderDTO> placeCustomerOrder(String userId, @Valid OrderDTO orderDTO) {
        var response = orderService.createCustomerOrder(userId, orderDTO);
        return ResponseEntity.ok(response);
    }

    @Override
    @Authorize(permission = "customer-order-write", selfAccess = true, roles = {"admin", "employee"})
    public ResponseEntity<OrderDTO> updateCustomerOrder(String customerOrderId, String userId, Integer rating,
            String status) {
        var response = orderService.updateCustomerOrder(customerOrderId, rating, status);
        return ResponseEntity.ok(response);
    }

    @Override
    @Authorize(permission = "customer-read-self", selfAccess = true)
    public ResponseEntity<List<CustomerOrderDTO>> queryOrdersForCustomer(String userId, Boolean isCurrent) {
        var response = orderService.queryOrdersForCustomer(userId, isCurrent);
        return ResponseEntity.ok(response);
    }

    
    @Override
    @Authorize(permission = "customer-read-self", selfAccess = true)
    public ResponseEntity<List<BookingDTO>> queryBookingsForCustomer(
            String userId,
            OffsetDateTime from,
            OffsetDateTime to) {
        var response = bookingService.queryCustomerBookings(userId, from, to);
        return ResponseEntity.ok(response);
    }

    @Override
    @Authorize(permission = "customer-read-self", selfAccess = true)
    public ResponseEntity<Integer> queryPointsForCustomer(String userId){
        var response = userService.getPoints(userId);
        return ResponseEntity.ok(response);
    }
}
