package bme.restaurant.service;

import java.util.List;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bme.restaurant.dao.Drink;
import bme.restaurant.dao.DrinkStockItem;
import bme.restaurant.dao.FoodStockItem;
import bme.restaurant.dao.Ingredient;
import bme.restaurant.dto.DrinkStockItemDTO;
import bme.restaurant.dto.FoodStockItemDTO;
import bme.restaurant.repository.DrinkRepository;
import bme.restaurant.repository.DrinkStockRepository;
import bme.restaurant.repository.FoodStockRepository;
import bme.restaurant.repository.IngredientRepository;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private DrinkStockRepository drinkStockRepo;

    @Autowired
    private DrinkRepository drinkRepo;

    @Autowired
    private FoodStockRepository foodStockRepo;

    @Autowired
    private IngredientRepository ingredientRepo;


    @Override
    public DrinkStockItemDTO createDrink(DrinkStockItemDTO drinkStockItemDTO) {
        Drink drink = drinkRepo.findByName(drinkStockItemDTO.getName());
        DrinkStockItem entity = new DrinkStockItem(drink, drinkStockItemDTO.getQuantity());
        entity = drinkStockRepo.save(entity);
        return entity.toDTO();
    }

    @Override
    public void deleteDrink(String drinkStockItemId) {
        drinkStockRepo.deleteById(drinkStockItemId);
    }

    @Override
    public List<DrinkStockItemDTO> getAllDrinks() {
        List<DrinkStockItem> drinkStockItems =  drinkStockRepo.findAll();
        List<DrinkStockItemDTO> drinkStockItemDTOs = new ArrayList<DrinkStockItemDTO>();
        for (DrinkStockItem drinkStockItem : drinkStockItems) {
            drinkStockItemDTOs.add(drinkStockItem.toDTO());
        }
        return drinkStockItemDTOs;
    }

    @Override
    public DrinkStockItemDTO updateDrink(String drinkStockItemId, String name, Integer quantity) { 
        DrinkStockItem drinkStockItem = drinkStockRepo.findById(drinkStockItemId).get();
        if (quantity != null) {
            drinkStockItem.setQuantity(quantity);
        }
        if (name != null){
            Drink drink = drinkStockItem.getDrink();
            drink.setName(name);
            drink = drinkRepo.save(drink);
            drinkStockItem.setDrink(drink);
        }
        drinkStockItem = drinkStockRepo.save(drinkStockItem);
        return drinkStockItem.toDTO();
    }

    @Override
    public FoodStockItemDTO createFood(FoodStockItemDTO foodStockItemDTO) {
        Ingredient ingredient = new Ingredient(foodStockItemDTO.getName(), foodStockItemDTO.getUnit().getValue());
        ingredientRepo.save(ingredient);
        FoodStockItem entity = new FoodStockItem(ingredient, foodStockItemDTO.getQuantity());
        entity = foodStockRepo.save(entity);
        return entity.toDTO();
    }

    @Override
    public void deleteFood(String foodStockItemId) {
        foodStockRepo.deleteById(foodStockItemId);
    }

    @Override
    public List<FoodStockItemDTO> getAllFoods() {
        List<FoodStockItem> foodStockItems = foodStockRepo.findAll();
        List<FoodStockItemDTO> foodStockItemDTOs = new ArrayList<>();
        for (FoodStockItem foodStockItem : foodStockItems) {
            foodStockItemDTOs.add(foodStockItem.toDTO());
        }
        return foodStockItemDTOs;
    }

    @Override
    public FoodStockItemDTO updateFood(String foodStockItemId, String name, Integer quantity, String unit) {
        FoodStockItem foodStockItem = foodStockRepo.findById(foodStockItemId).orElse(null);
        if (foodStockItem != null) {
            if (quantity != null) {
                foodStockItem.setQuantity(quantity);
            }
            if (name != null) {
                Ingredient ingredient = foodStockItem.getIngredient();
                ingredient.setName(name);
                ingredient = ingredientRepo.save(ingredient);
                foodStockItem.setIngredient(ingredient);
            }
            if (unit != null) {
                Ingredient ingredient = foodStockItem.getIngredient();
                ingredient.setUnit(unit);
                ingredient = ingredientRepo.save(ingredient);
                foodStockItem.setIngredient(ingredient);
            }
            foodStockItem = foodStockRepo.save(foodStockItem);
            return foodStockItem.toDTO();
        }
        return null;
    }

}
