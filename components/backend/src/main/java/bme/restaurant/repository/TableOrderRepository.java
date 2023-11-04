package bme.restaurant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import bme.restaurant.dao.Table;
import bme.restaurant.dao.TableOrder;

public interface TableOrderRepository extends MongoRepository<TableOrder,String> {
    TableOrder findByTable(Table table);
}
