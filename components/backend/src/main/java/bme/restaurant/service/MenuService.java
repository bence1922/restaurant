package bme.restaurant.service;

import java.util.List;

import org.springframework.stereotype.Component;

import bme.restaurant.dto.DrinkDTO;
import bme.restaurant.dto.FoodDTO;

@Component
public interface MenuService {
    public DrinkDTO addDrink(DrinkDTO drinkDTO);
    public FoodDTO addFood(FoodDTO foodDTO);
    public void deleteDrink(String drinkId);
    public void deleteFood(String foodId);
    public DrinkDTO getDrink(String drinkId);
    public List<DrinkDTO> getDrinks();
    public FoodDTO getFood(String foodId);
    public List<FoodDTO> getFoods();
    public DrinkDTO updateDrink(String drinkId, String name, Integer price);
    public FoodDTO updateFood(String foodId, String name, Integer price);
}
