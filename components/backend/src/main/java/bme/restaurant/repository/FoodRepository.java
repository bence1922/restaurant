package bme.restaurant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import bme.restaurant.dao.Food;
import jakarta.validation.constraints.NotNull;

public interface FoodRepository extends MongoRepository<Food,String> {
    Food findByName(@NotNull String name);
}
