package bme.restaurant.dao;

import java.util.List;

import bme.restaurant.dto.OrderDTO;

import java.time.LocalDateTime;
import java.time.ZoneId;

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

    public OrderDTO toDTO(){
        var dto = new OrderDTO(
            this.foods.stream().map(food -> food.toDTO()).toList(),
            this.drinks.stream().map(drink -> drink.toDTO()).toList()
        );
        dto.setStatus(OrderDTO.StatusEnum.fromValue(this.status));
        dto.setDate(date.atZone(ZoneId.of("Europe/Budapest")).toOffsetDateTime());
        return dto;
    }

    public static Order fromDTO(OrderDTO orderDTO) {
        return  new Order(
            orderDTO.getFoods().stream().map(food -> FoodOrderItem.fromDTO(food)).toList(),
            orderDTO.getDrinks().stream().map(drink -> DrinkOrderItem.fromDTO(drink)).toList(),
            orderDTO.getStatus().getValue(),
            orderDTO.getDate().toLocalDateTime()
        );
    }
}