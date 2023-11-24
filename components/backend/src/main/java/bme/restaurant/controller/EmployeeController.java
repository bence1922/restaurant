package bme.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bme.restaurant.api.EmployeeApi;
import bme.restaurant.auth.Authorize;
import bme.restaurant.dto.UserDTO;
import bme.restaurant.dto.UserRegisterDTO;
import bme.restaurant.service.UserServiceImpl;
import jakarta.validation.Valid;

@RestController
public class EmployeeController implements EmployeeApi {

    @Autowired
    private UserServiceImpl userService;
    
    @Override
    @Authorize(permission = "employee-list")
    public ResponseEntity<List<UserDTO>> getEmployees() {
        List<UserDTO> employees = userService.getEmployees();
        return ResponseEntity.ok(employees);
    }

    @Override
    @Authorize(permission = "emloyee-register")
    public ResponseEntity<UserDTO> registerEmployee(@Valid UserRegisterDTO userRegisterDTO) {
        UserDTO employee = userService.registerEmployee(userRegisterDTO);
        return ResponseEntity.ok(employee);
    }
}
