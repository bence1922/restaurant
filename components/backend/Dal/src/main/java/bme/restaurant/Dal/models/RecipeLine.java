package bme.restaurant.Dal.models;

import org.springframework.data.mongodb.core.mapping.DocumentReference;

public class RecipeLine {
    @DocumentReference
    private Ingredient ingredient;

    private int quantity;

    public RecipeLine(
            Ingredient ingredient,
            int quantity) {
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
