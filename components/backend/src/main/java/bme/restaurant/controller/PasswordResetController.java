package bme.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bme.restaurant.api.PasswordResetApi;
import bme.restaurant.service.UserService;
import jakarta.validation.constraints.NotNull;

@RestController
public class PasswordResetController implements PasswordResetApi {
    
    @Autowired
    UserService userService;
    
    @Override
    public ResponseEntity<Void> passwordReset(@NotNull String userId, @NotNull String oldPassword, @NotNull String newPassword) {
        userService.passwordReset(userId, oldPassword, newPassword);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
