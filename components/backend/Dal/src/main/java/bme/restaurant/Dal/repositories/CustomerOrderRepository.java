package bme.restaurant.Dal.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import bme.restaurant.Dal.models.CustomerOrder;

public interface CustomerOrderRepository extends MongoRepository<CustomerOrder,String> {
    
}
