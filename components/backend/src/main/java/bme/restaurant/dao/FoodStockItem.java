package bme.restaurant.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import bme.restaurant.dto.FoodStockItemDTO;
import bme.restaurant.dto.FoodStockItemDTO.UnitEnum;
@Document(collection = "food_stock")
public class FoodStockItem {
    @Id
    private String id;

    @DocumentReference
    private Ingredient ingredient;

    private int quantity;

    public FoodStockItem(
            Ingredient ingredient,
            int quantity) {
        super();  
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public FoodStockItemDTO toDTO() {
        FoodStockItemDTO foodStockItemDTO = new FoodStockItemDTO(this.ingredient.getName(), this.quantity, UnitEnum.fromValue(this.ingredient.getUnit()));
        foodStockItemDTO.setId(this.id);
        return foodStockItemDTO;
    }
}
