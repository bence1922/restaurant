package bme.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bme.restaurant.api.MenuApi;
import bme.restaurant.auth.Authorize;
import bme.restaurant.dto.DrinkDTO;
import bme.restaurant.dto.FoodDTO;
import bme.restaurant.service.MenuService;
import jakarta.validation.Valid;

@RestController
public class MenuController implements MenuApi {
    
    @Autowired
    private MenuService menuService;

    @Override
    @Authorize(permission = "menu-editor")
    public ResponseEntity<Void> addDrinkToMenu(@Valid DrinkDTO drinkDTO) {
        menuService.addDrink(drinkDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    @Authorize(permission = "menu-editor")
    public ResponseEntity<Void> addFoodToMenu(@Valid FoodDTO foodDTO) {
        menuService.addFood(foodDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    @Authorize(permission = "menu-editor")
    public ResponseEntity<Void> deleteDrink(String drinkId) {
        menuService.deleteDrink(drinkId);
        return ResponseEntity.noContent().build();
    }

    @Override
    @Authorize(permission = "menu-editor")
    public ResponseEntity<Void> deleteFood(String foodId) {
        menuService.deleteFood(foodId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<DrinkDTO> getDrink(String drinkId) {
        DrinkDTO drink = menuService.getDrink(drinkId);
        return ResponseEntity.ok(drink);
    }

    @Override
    public ResponseEntity<List<DrinkDTO>> getDrinkMenu() {
        List<DrinkDTO> drinks = menuService.getDrinks();
        return ResponseEntity.ok(drinks);
    }

    @Override
    public ResponseEntity<FoodDTO> getFood(String foodId) {
        FoodDTO food = menuService.getFood(foodId);
        return ResponseEntity.ok(food);
    }

    @Override
    public ResponseEntity<List<FoodDTO>> getFoodMenu() {
        List<FoodDTO> foods = menuService.getFoods();
        return ResponseEntity.ok(foods);
    }

    @Override
    @Authorize(permission = "menu-editor")
    public ResponseEntity<DrinkDTO> updateDrink(String drinkId, String name, Integer price) {
        DrinkDTO drink = menuService.updateDrink(drinkId, name, price);
        return ResponseEntity.ok(drink);
    }

    @Override
    @Authorize(permission = "menu-editor")
    public ResponseEntity<FoodDTO> updateFood(String foodId, String name, Integer price) {
        FoodDTO food = menuService.updateFood(foodId, name, price);
        return ResponseEntity.ok(food);
    }
}
