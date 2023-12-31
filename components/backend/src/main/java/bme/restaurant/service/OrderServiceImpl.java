package bme.restaurant.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import bme.restaurant.dao.CustomerOrder;
import bme.restaurant.dao.DrinkOrderItem;
import bme.restaurant.dao.Food;
import bme.restaurant.dao.FoodOrderItem;
import bme.restaurant.dao.Order;
import bme.restaurant.dao.TableOrder;
import bme.restaurant.dao.User;
import bme.restaurant.dto.CustomerOrderDTO;
import bme.restaurant.dto.DrinkOrderItemDTO;
import bme.restaurant.dto.FoodOrderItemDTO;
import bme.restaurant.dto.OrderDTO;
import bme.restaurant.dto.TableOrderDTO;
import bme.restaurant.repository.CustomerOrderRepository;
import bme.restaurant.repository.DrinkRepository;
import bme.restaurant.repository.FoodRepository;
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

    @Autowired
    private FoodRepository foodRepo;

    @Autowired
    private DrinkRepository drinkRepo;

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
    public List<CustomerOrderDTO> queryOrdersForCustomer(String userId, Boolean isCurrent) {
        Query query = new Query();

        var response = userRepo.findById(userId);
        if (response.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,
                    String.format("Customer not found with Id: %s", userId));
        }
        User customer = response.get();
        query.addCriteria(Criteria.where("customer").is(customer));
        
        if (isCurrent != null) {
            if (isCurrent) {
                query.addCriteria(Criteria.where("order.status").ne(OrderDTO.StatusEnum.DELIVERED.getValue()));
            } else {
                query.addCriteria(Criteria.where("order.status").is(OrderDTO.StatusEnum.DELIVERED.getValue()));
            }
        }

        var result = mongoTemplate.find(query, CustomerOrder.class);

        return result.stream().map(CustomerOrder::toDTO).collect(Collectors.toList());
    }

    @Override
    public OrderDTO createCustomerOrder(String userId, OrderDTO orderDTO) {
        var response = userRepo.findById(userId);
        if (response.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,
                    String.format("Customer not found with Id: %s", userId));
        }
        User customer = response.get();
        var customerOrder = new CustomerOrder(customer, createOrderFromDTO(orderDTO));
        customerOrder = customerOrderRepository.save(customerOrder);
        int points = customer.getPoints();
        if (points >= 2000) {
            points -= 2000;
        }
        else {
            for (DrinkOrderItemDTO drinkOrderItemDTO : orderDTO.getDrinks()) {
            points += (int) drinkOrderItemDTO.getDrink().getPrice() * 0.1;
            }
            for (FoodOrderItemDTO foodOrderItemDTO : orderDTO.getFoods()) {
                points += (int) foodOrderItemDTO.getFood().getPrice() * 0.1;
            }
            customer.setPoints(points);
        }
        userRepo.save(customer);
        return customerOrder.getOrder().toDTO();
    }

    @Override
    public OrderDTO updateCustomerOrder(String customerOrderId, Integer rating, String status) {
        var response = customerOrderRepository.findById(customerOrderId);
        if (response.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,
                    String.format("Customer order not found with Id: %s", customerOrderId));
        }
        var customerOrder = response.get();
        if (rating != null) {
            customerOrder.getOrder().setRating(rating);
        }
        if (status != null) {
            customerOrder.getOrder().setStatus(status);
        }
        customerOrder = customerOrderRepository.save(customerOrder);
        return customerOrder.getOrder().toDTO();
    }

    @Override
    public List<TableOrderDTO> queryTableOrders(Integer tableNumber, Boolean isCurrent) {
        Query query = new Query();

        if (tableNumber != null) {
            var table = tableRepo.findByNumber(tableNumber);
            if (table == null) {
                throw new HttpClientErrorException(HttpStatus.NOT_FOUND,
                        String.format("Table not found with Id: %s", tableNumber));
            }
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
        if (table == null) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,
                    String.format("Table not found with Id: %s", tableNumber));
        }
        var tableOrder = new TableOrder(table , createOrderFromDTO(orderDTO));
        tableOrder = tableOrderRepo.save(tableOrder);
        return tableOrder.toDTO();
    }

    @Override
    public OrderDTO updateTableOrder(String tableOrderId, Integer rating, String status) {
        var response = tableOrderRepo.findById(tableOrderId);
        if (response.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,
                    String.format("Table order not found with Id: %s", tableOrderId));
        }
        var tableOrder = response.get();
        if (rating != null) {
            tableOrder.getOrder().setRating(rating);
        }
        if (status != null) {
            tableOrder.getOrder().setStatus(status);
        }
        tableOrder = tableOrderRepo.save(tableOrder);
        return tableOrder.getOrder().toDTO();
    }

    private Order createOrderFromDTO(OrderDTO orderDTO) {
        var dao = new Order(
            orderDTO.getFoods().stream().map(food -> createFoodOrderItemfromDTO(food)).toList(),
            orderDTO.getDrinks().stream().map(drink -> createDrinkOrderItemFromDTO(drink)).toList(),
            orderDTO.getStatus().getValue(),
            orderDTO.getDate().toLocalDateTime()
        );
        dao.setRating(orderDTO.getRating());
        return dao;
    }

    private FoodOrderItem createFoodOrderItemfromDTO(FoodOrderItemDTO dto) {
        var foodId = dto.getFood().getId();
        if (foodId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Food id is required");
        }
        var response = foodRepo.findById(foodId);
        if (response.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,
                    String.format("Food not found with Id: %s", foodId));
        }
        return new FoodOrderItem(
                response.get(),
                dto.getQuantity());
    }

    private DrinkOrderItem createDrinkOrderItemFromDTO(DrinkOrderItemDTO dto) {
        var drinkId = dto.getDrink().getId();
        if (drinkId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Drink id is required");
        }
        var response = drinkRepo.findById(drinkId);
        if (response.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,
                    String.format("Drink not found with Id: %s", drinkId));
        }
        return new DrinkOrderItem(
                response.get(),
                dto.getQuantity());
    }
}
