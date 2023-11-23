package bme.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bme.restaurant.SpringApp;
import bme.restaurant.dao.User;
import bme.restaurant.dto.UserDTO;
import bme.restaurant.dto.UserLoginDTO;
import bme.restaurant.dto.UserSessionDTO;
import jakarta.validation.Valid;

import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private bme.restaurant.repository.UserRepository userRepo;

    @Override
    public UserSessionDTO login(UserLoginDTO userLoginDTO) {
        User user = userRepo.findByName(userLoginDTO.getName());
        if (user != null) {
            if(user.getPasswordHash().equals(userLoginDTO.getPassword())) {
                UUID uuid = UUID.randomUUID();
                String uniqueID = uuid.toString();
                UserSessionDTO userSessionDTO = new UserSessionDTO(uniqueID,user.toDTO(),user.getRole()+""); //TODO
                SpringApp.activeUserSessions.add(userSessionDTO);
                return userSessionDTO;
            }
        }
        return null;
    }

    @Override
    public void logout(String userName) {
        for (UserSessionDTO userSessionDTO : SpringApp.activeUserSessions){
            if (userSessionDTO.getUser().getName().equals(userName)) {
                SpringApp.activeUserSessions.remove(userSessionDTO);
                return;
            }
        }
    }

    @Override
    public void deleteUser(String userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public UserDTO getUserById(String userId) {
        var user = userRepo.findById(userId);
        if(user.isPresent()){
            User userValid = user.get();
            return new UserDTO(userValid.getName(),userValid.getEmail(),userValid.getMobilNumber(), userValid.getAddress());
        }
        return null;
    }

    @Override
    public UserDTO updateUserById(String userId, UserDTO userDTO) {
        User user = userRepo.findById(userId).get();
        user.setAddress(userDTO.getAddress());
        user.setEmail(userDTO.getEmail());
        user.setMobilNumber(userDTO.getMobil());
        user.setName(userDTO.getName());
        user.setRole(userDTO.getId());
        user = userRepo.save(user);
        return user.toDTO();
    }

    @Override
    public void passwordReset(String userId ,String oldPassword, String newPassword) {
        User user = userRepo.findById(userId).get();
        if (user.getPasswordHash().equals(oldPassword))
            user.setPasswordHash(newPassword);
    }
}
