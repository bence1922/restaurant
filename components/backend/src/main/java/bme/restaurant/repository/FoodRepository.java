package bme.restaurant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import bme.restaurant.dao.Food;

public interface FoodRepository extends MongoRepository<Food,String> {
    
}
