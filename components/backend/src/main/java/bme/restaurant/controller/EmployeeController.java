package bme.restaurant.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bme.restaurant.api.EmployeeApi;
import bme.restaurant.auth.Authorize;
import bme.restaurant.dto.UserDTO;
import bme.restaurant.dto.UserRegisterDTO;
import jakarta.validation.Valid;

@RestController
public class EmployeeController implements EmployeeApi {
    @Override
    @Authorize(permission = "employee-list")
    public ResponseEntity<List<UserDTO>> getEmployees() {
        // TODO Auto-generated method stub
        return EmployeeApi.super.getEmployees();
    }

    @Override
    @Authorize(permission = "emloyee-register")
    public ResponseEntity<UserDTO> registerEmployee(@Valid UserRegisterDTO userRegisterDTO) {
        // TODO Auto-generated method stub
        return EmployeeApi.super.registerEmployee(userRegisterDTO);
    }
}
