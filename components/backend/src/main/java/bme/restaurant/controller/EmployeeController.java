package bme.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bme.restaurant.api.EmployeeApi;
import bme.restaurant.auth.Authorize;
import bme.restaurant.dto.UserDTO;
import bme.restaurant.dto.UserRegisterDTO;
import bme.restaurant.service.UserService;
import jakarta.validation.Valid;

@RestController
public class EmployeeController implements EmployeeApi {

    @Autowired
    private UserService userService;
    
    @Override
    @Authorize(permission = "employee-list")
    public ResponseEntity<List<UserDTO>> getEmployees() {
        var response = userService.getEmployees();
        return ResponseEntity.ok(response);
    }

    @Override
    @Authorize(permission = "emloyee-register")
    public ResponseEntity<UserDTO> registerEmployee(@Valid UserRegisterDTO userRegisterDTO) {
        var response = userService.registerEmployee(userRegisterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
