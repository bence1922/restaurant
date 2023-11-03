package bme.restaurant.Dal.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import bme.restaurant.Dal.models.Ingredient;

public interface IngredientRepository extends MongoRepository<Ingredient,String> {
    
}
