package bme.restaurant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import bme.restaurant.dao.CustomerOrder;

public interface CustomerOrderRepository extends MongoRepository<CustomerOrder,String> {
    
}
