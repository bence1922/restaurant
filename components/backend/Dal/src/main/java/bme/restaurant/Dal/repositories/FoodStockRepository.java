package bme.restaurant.Dal.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import bme.restaurant.Dal.models.FoodStockItem;

public interface FoodStockRepository extends MongoRepository<FoodStockItem,String> {
    
}
