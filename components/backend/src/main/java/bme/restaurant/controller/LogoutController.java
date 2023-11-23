package bme.restaurant.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bme.restaurant.api.LogoutApi;
import bme.restaurant.service.UserServiceImpl;
import jakarta.validation.Valid;

@RestController
public class LogoutController implements LogoutApi {
    @Autowired
    private UserServiceImpl userService;

    @Override
    public ResponseEntity<Void> logout(@Valid String userName) {
        userService.logout(userName);
        return ResponseEntity.ok().build();
    }
}
