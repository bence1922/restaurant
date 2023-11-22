package bme.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bme.restaurant.dao.TableOrder;
import bme.restaurant.dto.DrinkDTO;
import bme.restaurant.dto.DrinkOrderItemDTO;
import bme.restaurant.dto.FoodDTO;
import bme.restaurant.dto.FoodOrderItemDTO;
import bme.restaurant.dto.FoodRecipeInnerDTO;
import bme.restaurant.dto.FoodRecipeInnerDTO.UnitEnum;
import bme.restaurant.dto.OrderDTO;
import bme.restaurant.repository.TableOrderRepository;
import bme.restaurant.repository.TableRepository;

@Service
public class TableOrderServiceImpl implements TableOrderService {

    @Autowired
    private TableRepository tableRepo;

    @Autowired
    private TableOrderRepository tableOrderRepo;

    @Override
    public OrderDTO findTableOrder(Integer tableNumber) {
        var table = tableRepo.findByNumber(tableNumber);
        var response = tableOrderRepo.findByTable(table);
        return mapOrder(response);
    }

    private OrderDTO mapOrder(TableOrder entity) {
        var order = entity.getOrder();
        var orderDto = new OrderDTO();

        for (var item : order.getFoods()) {
            var food = item.getFood();
            var foodDto = new FoodDTO();

            foodDto.setId(food.getId());
            foodDto.setName(food.getName());
            foodDto.setPrice(food.getPrice());
            for (var line : food.getRecipe()) {
                var lineDto = new FoodRecipeInnerDTO();
                lineDto.setIngerient(line.getIngredient().getName());
                lineDto.setUnit(UnitEnum.fromValue(line.getIngredient().getUnit()));
                lineDto.setQuantity(line.getQuantity());

                foodDto.addRecipeItem(lineDto);
            }

            var itemDto = new FoodOrderItemDTO();
            itemDto.setQuantity(item.getQuantity());
            itemDto.setFood(foodDto);

            orderDto.addFoodsItem(itemDto);
        }

        for (var item : order.getDrinks()) {
            var drink = item.getDrink();
            var drinkDto = new DrinkDTO();

            drinkDto.setId(drink.getId());
            drinkDto.setName(drink.getName());
            drinkDto.setPrice(drink.getPrice());

            var itemDto = new DrinkOrderItemDTO();
            itemDto.setQuantity(item.getQuantity());
            itemDto.setDrink(drinkDto);

            orderDto.addDrinksItem(itemDto);
        }

        return orderDto;
    }
}
