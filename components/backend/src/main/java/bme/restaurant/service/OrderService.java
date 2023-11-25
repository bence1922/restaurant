package bme.restaurant.service;

import java.util.List;

import bme.restaurant.dto.CustomerOrderDTO;
import bme.restaurant.dto.OrderDTO;
import bme.restaurant.dto.TableOrderDTO;

public interface OrderService {
    List<CustomerOrderDTO> queryCustomerOrders(String customerName, Boolean isCurrent);
    List<OrderDTO> queryOrdersForCustomer(String userId, Boolean isCurrent);
    OrderDTO createCustomerOrder(String userId, OrderDTO orderDTO);

    List<TableOrderDTO> queryTableOrders(Integer tableNumber, Boolean isCurrent);
    TableOrderDTO createTableOrder(Integer tableNumber, OrderDTO orderDTO);
}
