package bme.restaurant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import bme.restaurant.dao.FoodStockItem;

public interface FoodStockRepository extends MongoRepository<FoodStockItem,String> {
    
}
