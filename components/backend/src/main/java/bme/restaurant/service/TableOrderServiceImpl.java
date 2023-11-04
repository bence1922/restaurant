package bme.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bme.restaurant.dao.TableOrder;
import bme.restaurant.dto.Drink;
import bme.restaurant.dto.DrinkOrderItem;
import bme.restaurant.dto.Food;
import bme.restaurant.dto.FoodOrderItem;
import bme.restaurant.dto.FoodRecipeInner;
import bme.restaurant.dto.FoodRecipeInner.UnitEnum;
import bme.restaurant.dto.Order;
import bme.restaurant.repository.TableOrderRepository;
import bme.restaurant.repository.TableRepository;

@Service
public class TableOrderServiceImpl implements TableOrderService {

    @Autowired
    TableRepository tableRepo;

    @Autowired
    TableOrderRepository tableOrderRepo;

    @Override
    public Order findTableOrder(Integer tableNumber) {
        var table = tableRepo.findByNumber(tableNumber);
        var response = tableOrderRepo.findByTable(table);
        return mapOrder(response);
    }

    private Order mapOrder(TableOrder entity) {
        var order = entity.getOrder();
        var orderDto = new Order();

        for (var item : order.getFoods()) {
            var food = item.getFood();
            var foodDto = new Food();

            foodDto.setId(food.getId());
            foodDto.setName(food.getName());
            foodDto.setPrice(food.getPrice());
            for (var line : food.getRecipe()) {
                var dtoLine = new FoodRecipeInner();
                dtoLine.setIngerient(line.getIngredient().getName());
                dtoLine.setUnit(UnitEnum.fromValue(line.getIngredient().getUnit()));
                dtoLine.setQuantity(line.getQuantity());

                foodDto.addRecipeItem(dtoLine);
            }

            var itemDto = new FoodOrderItem();
            itemDto.setQuantity(item.getQuantity());
            itemDto.setFood(foodDto);

            orderDto.addFoodsItem(itemDto);
        }

        for (var item : order.getDrinks()) {
            var drink = item.getDrink();
            var drinkDto = new Drink();

            drinkDto.setId(drink.getId());
            drinkDto.setName(drink.getName());
            drinkDto.setPrice(drink.getPrice());

            var itemDto = new DrinkOrderItem();
            itemDto.setQuantity(item.getQuantity());
            itemDto.setDrink(drinkDto);

            orderDto.addDrinksItem(itemDto);
        }

        return orderDto;
    }
}
