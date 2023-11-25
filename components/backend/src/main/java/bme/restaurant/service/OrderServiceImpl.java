package bme.restaurant.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import bme.restaurant.dao.CustomerOrder;
import bme.restaurant.dao.Order;
import bme.restaurant.dao.TableOrder;
import bme.restaurant.dto.CustomerOrderDTO;
import bme.restaurant.dto.OrderDTO;
import bme.restaurant.dto.TableOrderDTO;
import bme.restaurant.repository.CustomerOrderRepository;
import bme.restaurant.repository.TableOrderRepository;
import bme.restaurant.repository.TableRepository;
import bme.restaurant.repository.UserRepository;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private TableRepository tableRepo;

    @Autowired
    private TableOrderRepository tableOrderRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public List<CustomerOrderDTO> queryCustomerOrders(String customerName, Boolean isCurrent) {
        Query query = new Query();

        if (customerName != null) {
            var customers = userRepo.findByNameContaining(customerName);
            query.addCriteria(Criteria.where("customer").in(customers));
        }

        if (isCurrent != null) {
            if (isCurrent) {
                query.addCriteria(Criteria.where("order.status").ne(OrderDTO.StatusEnum.DELIVERED.getValue()));
            } else {
                query.addCriteria(Criteria.where("order.status").is(OrderDTO.StatusEnum.DELIVERED.getValue()));
            }
        }

        var response = mongoTemplate.find(query, CustomerOrder.class);

        return response.stream().map(CustomerOrder::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> queryOrdersForCustomer(String userId, Boolean isCurrent) {
        Query query = new Query();

        if (userId != null) {
            var customer = userRepo.findById(userId);
            query.addCriteria(Criteria.where("customer").is(customer));
        }
        
        if (isCurrent != null) {
            if (isCurrent) {
                query.addCriteria(Criteria.where("order.status").ne(OrderDTO.StatusEnum.DELIVERED.getValue()));
            } else {
                query.addCriteria(Criteria.where("order.status").is(OrderDTO.StatusEnum.DELIVERED.getValue()));
            }
        }

        var response = mongoTemplate.find(query, CustomerOrder.class);

        return response.stream().map((co) -> co.getOrder().toDTO()).collect(Collectors.toList());
    }

    @Override
    public OrderDTO createCustomerOrder(String userId, OrderDTO orderDTO) {
        var customer = userRepo.findById(userId).orElseThrow();
        var customerOrder = new CustomerOrder(customer, Order.fromDTO(orderDTO));
        customerOrder = customerOrderRepository.save(customerOrder);
        return customerOrder.getOrder().toDTO();
    }

    @Override
    public List<TableOrderDTO> queryTableOrders(Integer tableNumber, Boolean isCurrent) {
        Query query = new Query();

        if (tableNumber != null) {
            var table = tableRepo.findByNumber(tableNumber);
            query.addCriteria(Criteria.where("table").is(table));
        }

        if (isCurrent != null) {
            if (isCurrent) {
                query.addCriteria(Criteria.where("order.status").ne(OrderDTO.StatusEnum.DELIVERED.getValue()));
            } else {
                query.addCriteria(Criteria.where("order.status").is(OrderDTO.StatusEnum.DELIVERED.getValue()));
            }
        }

        var response = mongoTemplate.find(query, TableOrder.class);

        return response.stream().map(TableOrder::toDTO).toList();
    }

    @Override
    public TableOrderDTO createTableOrder(Integer tableNumber, OrderDTO orderDTO) {
        var table = tableRepo.findByNumber(tableNumber);
        var tableOrder = new TableOrder(table , Order.fromDTO(orderDTO));
        tableOrder = tableOrderRepo.save(tableOrder);
        return tableOrder.toDTO();
    }
}
