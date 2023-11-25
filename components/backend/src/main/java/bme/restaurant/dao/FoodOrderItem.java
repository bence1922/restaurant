package bme.restaurant.dao;

import org.springframework.data.mongodb.core.mapping.DocumentReference;

import bme.restaurant.dto.FoodOrderItemDTO;

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

    public FoodOrderItemDTO toDTO() {
        var dto = new FoodOrderItemDTO();
        dto.setFood(food.toDTO());
        dto.setQuantity(quantity);
        return dto;
    }

    public static FoodOrderItem fromDTO(FoodOrderItemDTO dto) {
        return new FoodOrderItem(
                Food.fromDTO(dto.getFood()),
                dto.getQuantity());
    }

}
