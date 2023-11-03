package bme.restaurant.Dal.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import bme.restaurant.Dal.models.Rating;

public interface RatingRepository extends MongoRepository<Rating,String> {
    
}
