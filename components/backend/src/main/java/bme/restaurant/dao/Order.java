package bme.restaurant.dao;

import java.util.List;

import java.time.LocalDateTime;

public class Order {
    private List<FoodOrderItem> foods;

    private List<DrinkOrderItem> drinks;

    private String status;

    private LocalDateTime date;

    public Order(
            List<FoodOrderItem> foods,
            List<DrinkOrderItem> drinks,
            String status,
            LocalDateTime date) {
        this.foods = foods;
        this.drinks = drinks;
        this.status = status;
        this.date = date;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
