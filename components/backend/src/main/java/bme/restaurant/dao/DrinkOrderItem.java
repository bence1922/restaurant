package bme.restaurant.dao;

import org.springframework.data.mongodb.core.mapping.DocumentReference;

public class DrinkOrderItem {
    @DocumentReference
    private Drink drink;

    private int quantity;

    public DrinkOrderItem(
            Drink drink,
            int quantity) {
        this.drink = drink;
        this.quantity = quantity;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
