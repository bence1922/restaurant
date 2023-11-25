package bme.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bme.restaurant.api.UserApi;
import bme.restaurant.auth.Authorize;
import bme.restaurant.dto.UserDTO;
import bme.restaurant.service.UserService;
import jakarta.validation.Valid;

@RestController
public class UserController implements UserApi {
    
    @Autowired
    UserService userService;

    @Override
    @Authorize(permission = "default", selfAccess = true, roles = {"admin"})
    public ResponseEntity<Void> deleteUserById(String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @Override
    @Authorize(permission = "default", selfAccess = true, roles = {"admin"})
    public ResponseEntity<UserDTO> getUserById(String userId) {
        var response = userService.getUserById(userId);
        return ResponseEntity.ok(response);
    }

    @Override
    @Authorize(permission = "default", selfAccess = true, roles = {"admin"})
    public ResponseEntity<UserDTO> updateUserById(String userId, @Valid UserDTO userDTO) {
        var response = userService.updateUserById(userId, userDTO);
        return ResponseEntity.ok(response);
    }
}
