package bme.restaurant.service;

import org.checkerframework.checker.units.qual.t;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.session.MapSession;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import bme.restaurant.dao.User;
import bme.restaurant.dto.UserDTO;
import bme.restaurant.dto.UserLoginDTO;
import bme.restaurant.dto.UserRegisterDTO;
import bme.restaurant.dto.UserSessionDTO;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private bme.restaurant.repository.UserRepository userRepo;

    @Autowired
    private SessionRepository<MapSession> sessionRepository;

    @Autowired
    private HttpServletRequest request;

    @Override
    public UserSessionDTO login(UserLoginDTO userLoginDTO) {
        User user = userRepo.findByName(userLoginDTO.getName());
        if (user != null) {
            if (BCrypt.checkpw(userLoginDTO.getPassword(), user.getPasswordHash())) {
                UUID uuid = UUID.randomUUID();
                String uniqueID = uuid.toString();

                var session = sessionRepository.createSession();
                session.setId(uniqueID);
                session.setAttribute("role", user.getRole());
                session.setAttribute("userId", user.getId());
                session.setAttribute("timeout", LocalDateTime.now().plusMinutes(30));
                sessionRepository.save(session);

                UserSessionDTO userSessionDTO = new UserSessionDTO(uniqueID, user.toDTO(), user.getRole());
                return userSessionDTO;
            }
            throw new RuntimeException("Invalid password");
        }
        throw new RuntimeException("Invalid username");
    }

    @Override
    public void logout() {
        String sessionId = request.getHeader("sessionId");
        sessionRepository.deleteById(sessionId);
    }

    @Override
    public void deleteUser(String userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public UserDTO getUserById(String userId) {
        var response = userRepo.findById(userId);
        if (response.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,
                    String.format("User not found with Id: %s", userId));
        }
        var user = response.get();
        return user.toDTO();
    }

    @Override
    public UserDTO updateUserById(String userId, UserDTO userDTO) {
        var response = userRepo.findById(userId);
        if (response.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,
                    String.format("User not found with Id: %s", userId));
        }
        var user = response.get();
        user.setAddress(userDTO.getAddress());
        user.setEmail(userDTO.getEmail());
        user.setMobilNumber(userDTO.getMobil());
        user.setName(userDTO.getName());
        user.setRole(userDTO.getId());
        user = userRepo.save(user);
        return user.toDTO();
    }

    @Override
    public void passwordReset(String userId, String oldPassword, String newPassword) {
        var response = userRepo.findById(userId);
        if (response.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,
                    String.format("User not found with Id: %s", userId));
        }
        var user = response.get();
        if (!BCrypt.checkpw(oldPassword, user.getPasswordHash()))
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Invalid old password");
        user.setPasswordHash(BCrypt.hashpw(newPassword, BCrypt.gensalt()));
    }

    @Override
    public List<UserDTO> getEmployees() {
        List<User> entities = userRepo.findByRole("employee");
        List<UserDTO> employees = new ArrayList<>();
        for (User user : entities) {
            employees.add(user.toDTO());
        }
        return employees;
    }

    @Override
    public List<UserDTO> getCustomers() {
        List<User> entities = userRepo.findByRole("customer");
        List<UserDTO> employees = new ArrayList<>();
        for (User user : entities) {
            employees.add(user.toDTO());
        }
        return employees;
    }

    @Override
    public UserDTO registerEmployee(UserRegisterDTO userRegisterDTO) {
        return registerUser(userRegisterDTO, "employee");
    }

    @Override
    public UserDTO registerCustomer(UserRegisterDTO userRegisterDTO) {
        return registerUser(userRegisterDTO, "customer");
    }

    private UserDTO registerUser(UserRegisterDTO userRegisterDTO, String role) {
        var response = userRepo.findByName(userRegisterDTO.getName());
        if (response != null) {
            throw new HttpClientErrorException(HttpStatus.CONFLICT,
                    String.format("User already exists with name: %s", userRegisterDTO.getName()));
        }
        String passwordHash = BCrypt.hashpw(userRegisterDTO.getPassword(), BCrypt.gensalt());
        User user = new User(userRegisterDTO.getName(), userRegisterDTO.getAddress(), userRegisterDTO.getMobil(),
                userRegisterDTO.getMobil(), passwordHash, role);
        user = userRepo.save(user);
        return user.toDTO();
    }

    @Override
    public int getPoints(String userId) {
        User user = userRepo.findById(userId).get();
        return user.getPoints();
    }
}
