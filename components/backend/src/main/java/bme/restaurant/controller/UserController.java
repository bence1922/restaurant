package bme.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import bme.restaurant.api.UserApi;
import bme.restaurant.dto.UserDTO;
import bme.restaurant.service.UserService;
import jakarta.validation.Valid;

@RestController
public class UserController implements UserApi {
    
    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<Void> deleteUserById(String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UserDTO> getUserById(String userId) {
        UserDTO response = userService.getUserById(userId);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<UserDTO> updateUserById(String userId, @Valid UserDTO userDTO) {
        UserDTO response = userService.updateUserById(userId, userDTO);
        return ResponseEntity.ok(response);
    }
}
