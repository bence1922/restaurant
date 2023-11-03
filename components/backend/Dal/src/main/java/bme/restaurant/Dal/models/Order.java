package bme.restaurant.Dal.models;

import java.util.List;

public class Order {
    private String id;

    private List<FoodOrderItem> foods;

    private List<DrinkOrderItem> drinks;

    public Order(
            String id,
            List<FoodOrderItem> foods,
            List<DrinkOrderItem> drinks) {
        this.id = id;
        this.foods = foods;
        this.drinks = drinks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
