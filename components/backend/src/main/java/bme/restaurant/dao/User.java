package bme.restaurant.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import bme.restaurant.dto.UserDTO;

@Document(collection = "users")
public class User {
    @Id
    private String id;

    private String name;

    private String address;

    private String mobilNumber;

    private String email;

    private String passwordHash;

    private String role;

    private int points;

    public User(
            String name,
            String address,
            String mobilNumber,
            String email,
            String passwordHash,
            String role) {
        super();  
        this.name = name;
        this.address = address;
        this.mobilNumber = mobilNumber;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
        this.points = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobilNumber() {
        return mobilNumber;
    }

    public void setMobilNumber(String mobilNumber) {
        this.mobilNumber = mobilNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getPoints() {
        return this.points;
    }
    
    public void setPoints(int points) {
        this.points = points;
    }

    public UserDTO toDTO() {
        var dto = new UserDTO(
            name,
            address,
            mobilNumber,
            email
        );
        dto.setId(id);
        return dto;
    }
}
