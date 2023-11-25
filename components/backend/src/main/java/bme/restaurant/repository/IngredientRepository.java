package bme.restaurant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import bme.restaurant.dao.Ingredient;

public interface IngredientRepository extends MongoRepository<Ingredient,String> {
    Ingredient findByName(String name);
}
