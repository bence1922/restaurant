package bme.restaurant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import bme.restaurant.dao.Table;

@Repository
public interface TableRepository extends MongoRepository<Table, String> {
    @Query("{'number':?0}")
    Table findTableByNumber(int number);

    public long count();
}
