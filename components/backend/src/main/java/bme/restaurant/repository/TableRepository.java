package bme.restaurant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import bme.restaurant.dao.Table;

@Repository
public interface TableRepository extends MongoRepository<Table, String> {
    Table findByNumber(int number);
    Table deleteByNumber(int number);
}
