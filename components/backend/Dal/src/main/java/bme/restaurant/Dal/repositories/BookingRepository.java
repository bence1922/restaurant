package bme.restaurant.Dal.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import bme.restaurant.Dal.models.Booking;

public interface BookingRepository extends MongoRepository<Booking,String> {
    
}
