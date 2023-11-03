package bme.restaurant.Dal.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import bme.restaurant.Dal.models.DrinkStockItem;

public interface DrinkStockRepository extends MongoRepository<DrinkStockItem,String> {
    
}
