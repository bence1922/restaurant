package bme.restaurant.Dal.models;

import org.springframework.data.mongodb.core.mapping.DocumentReference;

public class FoodOrderItem {
    @DocumentReference
    private Food food;

    private int quantity;

    public FoodOrderItem(
            Food food,
            int quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
