package bme.restaurant.dao;

import java.util.List;

public class Order {
    private List<FoodOrderItem> foods;

    private List<DrinkOrderItem> drinks;

    private OrderStatus status;

    public Order(
            List<FoodOrderItem> foods,
            List<DrinkOrderItem> drinks) {
        this.foods = foods;
        this.drinks = drinks;
    }

    public List<FoodOrderItem> getFoods() {
        return foods;
    }

    public void setFoods(List<FoodOrderItem> foods) {
        this.foods = foods;
    }

    public List<DrinkOrderItem> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<DrinkOrderItem> drinks) {
        this.drinks = drinks;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
