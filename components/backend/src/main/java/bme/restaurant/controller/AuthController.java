package bme.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bme.restaurant.api.AuthApi;
import bme.restaurant.auth.Authorize;
import bme.restaurant.dto.UserLoginDTO;
import bme.restaurant.dto.UserSessionDTO;
import bme.restaurant.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
public class AuthController implements AuthApi {
    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<UserSessionDTO> login(@Valid UserLoginDTO userLoginDTO) {
        var response = userService.login(userLoginDTO);
        return ResponseEntity.ok(response);
    }

    @Override
    @Authorize(permission = "default")
    public ResponseEntity<Void> logout() {
        userService.logout();
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> passwordReset(@NotNull String userId, @NotNull String oldPassword,
            @NotNull String newPassword) {
        userService.passwordReset(userId, oldPassword, newPassword);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
