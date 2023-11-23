package bme.restaurant.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bme.restaurant.api.LogoutApi;
import bme.restaurant.auth.Authorize;
import bme.restaurant.service.UserServiceImpl;

@RestController
public class LogoutController implements LogoutApi {
    @Autowired
    private UserServiceImpl userService;

    @Override
    @Authorize(permission = "default")
    public ResponseEntity<Void> logout() {
        userService.logout();
        return ResponseEntity.ok().build();
    }
}
