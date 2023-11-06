package bme.restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import bme.restaurant.dao.Drink;
import bme.restaurant.dao.DrinkOrderItem;
import bme.restaurant.dao.Food;
import bme.restaurant.dao.FoodOrderItem;
import bme.restaurant.dao.Ingredient;
import bme.restaurant.dao.Order;
import bme.restaurant.dao.RecipeLine;
import bme.restaurant.dao.Table;
import bme.restaurant.dao.TableOrder;
import bme.restaurant.repository.DrinkRepository;
import bme.restaurant.repository.FoodRepository;
import bme.restaurant.repository.IngredientRepository;
import bme.restaurant.repository.TableOrderRepository;
import bme.restaurant.repository.TableRepository;

@Component
public class DataSeeder implements CommandLineRunner {

	@Autowired
	IngredientRepository ingredientRepo;

	@Autowired
	FoodRepository foodRepo;

	@Autowired
	DrinkRepository drinkRepo;

	@Autowired
	TableRepository tableRepo;

	@Autowired
	TableOrderRepository tableOrderRepo;

	@Override
	public void run(String... args) throws Exception {
		seed();
	}

	private void seed() {
		// ingredients
		Ingredient meat = new Ingredient("meat", "g");
		Ingredient potato = new Ingredient("potato", "g");
		if (ingredientRepo.count() == 0) {
			meat = ingredientRepo.save(meat);
			potato = ingredientRepo.save(potato);
		}

		// food stock

		// foods
		RecipeLine meatLine = new RecipeLine(meat, 200);
		RecipeLine potatoLine = new RecipeLine(potato, 200);
		Food meatWithPotato = new Food(
				"Meat with potato",
				3000,
				"meal",
				List.of(meatLine, potatoLine));
		if (foodRepo.count() == 0) {
			meatWithPotato = foodRepo.save(meatWithPotato);
		}

		// drinks
		Drink iceTeaGreen = new Drink("Green Ice Tea", 400, "tea");
		if (drinkRepo.count() == 0) {
			iceTeaGreen = drinkRepo.save(iceTeaGreen);
		}

		// drink stock


		// tables
		Table table42 = new Table(42, 6, 0);
		if (tableRepo.count() == 0) {
			table42 = tableRepo.save(table42);
		}

		// table Orders
		FoodOrderItem meatWithPotatoOrder1 = new FoodOrderItem(meatWithPotato, 2);
		DrinkOrderItem iceTeaGreenOrder1 = new DrinkOrderItem(iceTeaGreen, 2);
		Order order1 = new Order(List.of(meatWithPotatoOrder1), List.of(iceTeaGreenOrder1));
		TableOrder table42Order1 = new TableOrder(table42, order1);
		if (tableOrderRepo.count() == 0) {
			table42Order1 = tableOrderRepo.save(table42Order1);
		}
	}
}
