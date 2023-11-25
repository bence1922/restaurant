package bme.restaurant.service;

import bme.restaurant.dto.DrinkStockItemDTO;
import bme.restaurant.dto.FoodStockItemDTO;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface StockService {
    public DrinkStockItemDTO createDrink(DrinkStockItemDTO drinkStockItemDTO);
    public void deleteDrink(String drinkStockItemId);
    public List<DrinkStockItemDTO> getAllDrinks();
    public DrinkStockItemDTO updateDrink(String drinkStockItemId, String name, Integer quantity);
    FoodStockItemDTO createFood(FoodStockItemDTO foodStockItemDTO);
    void deleteFood(String foodStockItemId);
    List<FoodStockItemDTO> getAllFoods();
    FoodStockItemDTO updateFood(String foodStockItemId, String name, Integer quantity, String unit);
}
