package bme.restaurant.Dal.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "customer_orders")
public class CustomerOrder {
    @Id
    private String id;

    @DocumentReference
    private User customer;

    private Order order;

    public CustomerOrder(
            User table,
            Order order) {
        super();  
        this.customer = table;
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

    public void setCustomer(User table) {
        this.customer = table;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
