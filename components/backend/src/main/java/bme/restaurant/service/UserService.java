package bme.restaurant.service;

import org.springframework.stereotype.Component;

import bme.restaurant.dto.UserDTO;
import bme.restaurant.dto.UserLoginDTO;
import bme.restaurant.dto.UserSessionDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Component
public interface UserService {
    public UserSessionDTO login(UserLoginDTO userLoginDTO);
    public void logout(String userName);
    public void deleteUser(String userId);
    public UserDTO getUserById(String userId);
    public UserDTO updateUserById(String userId, UserDTO userDTO);
    public void passwordReset(String userId, String oldPassword, String newPassword);
}
