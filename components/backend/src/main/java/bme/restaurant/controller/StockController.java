package bme.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import bme.restaurant.api.StockApi;
import bme.restaurant.dto.DrinkStockItemDTO;
import bme.restaurant.dto.FoodStockItemDTO;
import bme.restaurant.service.StockServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StockController implements StockApi {

    @Autowired
    private StockServiceImpl stockService;

    @Override
    public ResponseEntity<DrinkStockItemDTO> createDrinkStockItem(@Valid DrinkStockItemDTO drinkStockItemDTO) {
        DrinkStockItemDTO response = stockService.createDrink(drinkStockItemDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<FoodStockItemDTO> createFoodStockItem(@Valid FoodStockItemDTO foodStockItemDTO) {
        FoodStockItemDTO response = stockService.createFood(foodStockItemDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<Void> deleteDrinkStockItem(String drinkStockItemId) {
        stockService.deleteDrink(drinkStockItemId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteFoodStockItem(String foodStockItemId) {
        stockService.deleteFood(foodStockItemId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<DrinkStockItemDTO>> getAllDrinkStockItems() {
        List<DrinkStockItemDTO> drinks = stockService.getAllDrinks();
        return ResponseEntity.ok(drinks);
    }

    @Override
    public ResponseEntity<List<FoodStockItemDTO>> getAllFoodStockItems() {
        List<FoodStockItemDTO> foods = stockService.getAllFoods();
        return ResponseEntity.ok(foods);
    }

    @Override
    public ResponseEntity<DrinkStockItemDTO> partiallyUpdateDrinkStockItem(
            String drinkStockItemId,
            @Valid String name,
            @Valid Integer quantity) {
        DrinkStockItemDTO response = stockService.updateDrink(drinkStockItemId, name, quantity);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<FoodStockItemDTO> partiallyUpdateFoodStockItem(
            String foodStockItemId,
            @Valid String name,
            @Valid Integer quantity,
            @Valid String unit) {
        FoodStockItemDTO response = stockService.updateFood(foodStockItemId, name, quantity, unit);
        return ResponseEntity.ok(response);
    }
}
