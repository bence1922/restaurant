package bme.restaurant.Dal.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import bme.restaurant.Dal.models.TableOrder;

public interface TableOrderRepository extends MongoRepository<TableOrder,String> {
    
}
