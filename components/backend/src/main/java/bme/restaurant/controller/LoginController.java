package bme.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bme.restaurant.api.LoginApi;
import bme.restaurant.dto.UserLoginDTO;
import bme.restaurant.dto.UserSessionDTO;
import bme.restaurant.service.UserServiceImpl;
import jakarta.validation.Valid;

@RestController
public class LoginController implements LoginApi {
    @Autowired
    private UserServiceImpl userService;

    @Override
    public ResponseEntity<UserSessionDTO> login(@Valid UserLoginDTO userLoginDTO) {
        var response = userService.login(userLoginDTO);
        return ResponseEntity.ok(response);
    }
}
