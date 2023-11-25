package bme.restaurant.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import bme.restaurant.dto.CustomerOrderDTO;

@Document(collection = "customer_orders")
public class CustomerOrder {
    @Id
    private String id;

    @DocumentReference
    private User customer;

    private Order order;

    public CustomerOrder(
            User customer,
            Order order) {
        super();
        this.customer = customer;
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public CustomerOrderDTO toDTO() {
        return  new CustomerOrderDTO(
                this.id,
                this.customer.toDTO(),
                this.order.toDTO());
    }
}
