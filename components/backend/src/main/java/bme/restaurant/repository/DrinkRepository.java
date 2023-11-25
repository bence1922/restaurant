package bme.restaurant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import bme.restaurant.dao.Drink;

public interface DrinkRepository extends MongoRepository<Drink,String> {

    Drink findByName(String name);
    
}
