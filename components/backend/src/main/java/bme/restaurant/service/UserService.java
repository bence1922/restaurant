package bme.restaurant.service;

import java.util.List;

import org.springframework.stereotype.Component;

import bme.restaurant.dto.UserDTO;
import bme.restaurant.dto.UserLoginDTO;
import bme.restaurant.dto.UserRegisterDTO;
import bme.restaurant.dto.UserSessionDTO;

@Component
public interface UserService {
    public UserSessionDTO login(UserLoginDTO userLoginDTO);
    public void logout();
    public void deleteUser(String userId);
    public UserDTO getUserById(String userId);
    public UserDTO updateUserById(String userId, UserDTO userDTO);
    public void passwordReset(String userId, String oldPassword, String newPassword);
    public List<UserDTO> getEmployees();
    public List<UserDTO> getCustomers();
    public UserDTO registerEmployee(UserRegisterDTO userRegisterDTO);
    public UserDTO registerCustomer(UserRegisterDTO userRegisterDTO);
}
