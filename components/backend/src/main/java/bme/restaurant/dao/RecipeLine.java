package bme.restaurant.dao;

import org.springframework.data.mongodb.core.mapping.DocumentReference;

import bme.restaurant.dto.FoodRecipeInnerDTO;
import bme.restaurant.dto.FoodRecipeInnerDTO.UnitEnum;

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

    public FoodRecipeInnerDTO toDTO() {
        FoodRecipeInnerDTO foodRecipeInnerDTO = new FoodRecipeInnerDTO();
        foodRecipeInnerDTO.setIngerient(this.ingredient.getName());
        foodRecipeInnerDTO.setQuantity(this.quantity);
        foodRecipeInnerDTO.setUnit(UnitEnum.fromValue(this.ingredient.getUnit()));
        return foodRecipeInnerDTO;
    }
}
