package bme.restaurant.Dal.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import bme.restaurant.Dal.models.Drink;

public interface DrinkRepository extends MongoRepository<Drink,String> {
    
}
