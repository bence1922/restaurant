package bme.restaurant.Dal.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import bme.restaurant.Dal.models.User;

@Repository
public interface TableRepository extends MongoRepository<User, String> {
    @Query("{'number':?0}")
    User findTableByNumber(int number);

    public long count();
}
