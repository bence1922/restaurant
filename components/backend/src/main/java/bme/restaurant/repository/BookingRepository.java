package bme.restaurant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import bme.restaurant.dao.Booking;

public interface BookingRepository extends MongoRepository<Booking,String> {
    
}
