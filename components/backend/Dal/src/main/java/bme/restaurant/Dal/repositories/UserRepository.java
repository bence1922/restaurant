package bme.restaurant.Dal.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import bme.restaurant.Dal.models.User;

public interface UserRepository extends MongoRepository<User, String> {

}
