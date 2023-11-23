package bme.restaurant.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import bme.restaurant.dao.User;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByNameContaining(String name);
    User findByName(String name);
}
