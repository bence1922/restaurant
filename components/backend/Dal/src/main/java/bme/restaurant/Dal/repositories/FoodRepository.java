package bme.restaurant.Dal.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import bme.restaurant.Dal.models.Food;

public interface FoodRepository extends MongoRepository<Food,String> {
    
}
