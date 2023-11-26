package bme.restaurant.service;

import java.util.List;

import bme.restaurant.dto.CustomerOrderDTO;
import bme.restaurant.dto.OrderDTO;
import bme.restaurant.dto.TableOrderDTO;

public interface OrderService {
    List<CustomerOrderDTO> queryCustomerOrders(String customerName, Boolean isCurrent);
    List<CustomerOrderDTO> queryOrdersForCustomer(String userId, Boolean isCurrent);
    OrderDTO createCustomerOrder(String userId, OrderDTO orderDTO);
    OrderDTO updateCustomerOrder(String customerOrderId, Integer rating, String status);

    List<TableOrderDTO> queryTableOrders(Integer tableNumber, Boolean isCurrent);
    TableOrderDTO createTableOrder(Integer tableNumber, OrderDTO orderDTO);
    OrderDTO updateTableOrder(String tableOrderId, Integer rating, String status);
}
