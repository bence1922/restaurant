package bme.restaurant.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.MapSession;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Service;

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
    private SessionRepository<MapSession>  sessionRepository;

    @Autowired
    private HttpServletRequest request;

    @Override
    public UserSessionDTO login(UserLoginDTO userLoginDTO) {
        User user = userRepo.findByName(userLoginDTO.getName());
        if (user != null) {
            if (user.getPasswordHash().equals(BCrypt.hashpw(userLoginDTO.getPassword(), BCrypt.gensalt()))) {
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
        }
        return null;
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
        var user = userRepo.findById(userId);
        if (user.isPresent()) {
            User userValid = user.get();
            return new UserDTO(userValid.getName(), userValid.getEmail(), userValid.getMobilNumber(),
                    userValid.getAddress());
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
    public void passwordReset(String userId, String oldPassword, String newPassword) {
        User user = userRepo.findById(userId).get();
        if (user.getPasswordHash().equals(BCrypt.hashpw(oldPassword, BCrypt.gensalt())))
            user.setPasswordHash(BCrypt.hashpw(newPassword, BCrypt.gensalt()));
    }
    
    @Override
    public List<UserDTO> getEmployees() {
        List<User> entities = userRepo.findByRole("employee");
        List<UserDTO> employees = new ArrayList<>();
        for (User user : entities){
            employees.add(user.toDTO());
        }
        return employees;
    }

    @Override
    public List<UserDTO> getCustomers() {
        List<User> entities = userRepo.findByRole("customer");
        List<UserDTO> employees = new ArrayList<>();
        for (User user : entities){
            employees.add(user.toDTO());
        }
        return employees;
    }

    @Override
    public UserDTO registerEmployee(UserRegisterDTO userRegisterDTO) {
        String passwordHash = BCrypt.hashpw(userRegisterDTO.getPassword(), BCrypt.gensalt());
        User user = new User(userRegisterDTO.getName(), userRegisterDTO.getAddress(), userRegisterDTO.getMobil(), userRegisterDTO.getMobil(), passwordHash, "employee");
        user = userRepo.save(user);
        return user.toDTO();
    }

    @Override
    public UserDTO registerCustomer(UserRegisterDTO userRegisterDTO) {
        String passwordHash = BCrypt.hashpw(userRegisterDTO.getPassword(), BCrypt.gensalt());
        User user = new User(userRegisterDTO.getName(), userRegisterDTO.getAddress(), userRegisterDTO.getMobil(), userRegisterDTO.getMobil(), passwordHash, "customer");
        user = userRepo.save(user);
        return user.toDTO();
    }
}
