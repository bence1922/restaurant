package bme.restaurant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import bme.restaurant.dao.User;

public interface UserRepository extends MongoRepository<User, String> {

}
