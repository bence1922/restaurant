package bme.restaurant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import bme.restaurant.dao.DrinkStockItem;

public interface DrinkStockRepository extends MongoRepository<DrinkStockItem,String> {
    
}
