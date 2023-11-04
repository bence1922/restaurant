package bme.restaurant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import bme.restaurant.dao.Rating;

public interface RatingRepository extends MongoRepository<Rating,String> {
    
}
