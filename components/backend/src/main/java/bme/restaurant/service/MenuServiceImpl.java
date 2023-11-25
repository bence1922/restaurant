package bme.restaurant.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bme.restaurant.dao.Drink;
import bme.restaurant.dao.Food;
import bme.restaurant.dao.Ingredient;
import bme.restaurant.dao.RecipeLine;
import bme.restaurant.dto.DrinkDTO;
import bme.restaurant.dto.FoodDTO;
import bme.restaurant.dto.FoodRecipeInnerDTO;
import bme.restaurant.dto.DrinkDTO.TypeEnum;
import bme.restaurant.repository.DrinkRepository;
import bme.restaurant.repository.FoodRepository;
import bme.restaurant.repository.IngredientRepository;
import java.util.List;
import java.util.ArrayList;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private DrinkRepository drinkRepo;

    @Autowired
    private FoodRepository foodRepo;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public DrinkDTO addDrink(DrinkDTO drinkDTO) {
        var drink = new Drink(drinkDTO.getName(), drinkDTO.getPrice(), drinkDTO.getType().getValue());
        drink = drinkRepo.save(drink);
        return drink.toDTO();
    }

    @Override
    public FoodDTO addFood(FoodDTO foodDTO) {
        List<RecipeLine> recipe = new ArrayList<RecipeLine>();
        for(FoodRecipeInnerDTO recipeLineInnerDTO : foodDTO.getRecipe()){
            Ingredient ingredient = ingredientRepository.findByName(recipeLineInnerDTO.getIngerient());
            RecipeLine recipeLine = new RecipeLine(ingredient, recipeLineInnerDTO.getQuantity());
            recipe.add(recipeLine);
        }
        var food = new Food(foodDTO.getName(), foodDTO.getPrice(), foodDTO.getType().getValue(), recipe);
        food = foodRepo.save(food);
        return food.toDTO();
    }

    @Override
    public void deleteDrink(String drinkId) {
        drinkRepo.deleteById(drinkId);
    }

    @Override
    public void deleteFood(String foodId) {
        foodRepo.deleteById(foodId);
    }

    @Override
    public DrinkDTO getDrink(String drinkId) {
        Drink drink = drinkRepo.findById(drinkId).get();
        return drink.toDTO();
    }

    @Override
    public List<DrinkDTO> getDrinks() {
        List<DrinkDTO> drinks = new ArrayList<>(); 
        for (Drink drink : drinkRepo.findAll()){
            drinks.add(drink.toDTO());
        }
        return drinks;
    }

    @Override
    public FoodDTO getFood(String foodId) {
        Food food = foodRepo.findById(foodId).get();
        return food.toDTO();
    }

    @Override
    public List<FoodDTO> getFoods() {
        List<FoodDTO> foods = new ArrayList<>(); 
        for (Food food : foodRepo.findAll()){
            foods.add(food.toDTO());
        }
        return foods;
    }

    @Override
    public DrinkDTO updateDrink(String drinkId, String name, Integer price) {
        Drink drink = drinkRepo.findById(drinkId).get();
        if (name != null) 
            drink.setName(name);            
        if(price != null)
            drink.setPrice(price);
        drink = drinkRepo.save(drink);
        return drink.toDTO();
    }

    @Override
    public FoodDTO updateFood(String foodId, String name, Integer price) {
        Food food = foodRepo.findById(foodId).get();
        if (name != null) 
            food.setName(name);            
        if(price != null)
            food.setPrice(price);
        food = foodRepo.save(food);
        return food.toDTO();
    }
}
