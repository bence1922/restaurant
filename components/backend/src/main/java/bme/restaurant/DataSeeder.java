package bme.restaurant;

import java.time.LocalDateTime;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import bme.restaurant.dao.Booking;
import bme.restaurant.dao.Drink;
import bme.restaurant.dao.DrinkOrderItem;
import bme.restaurant.dao.Food;
import bme.restaurant.dao.FoodOrderItem;
import bme.restaurant.dao.Ingredient;
import bme.restaurant.dao.Order;
import bme.restaurant.dao.RecipeLine;
import bme.restaurant.dao.Table;
import bme.restaurant.dao.TableOrder;
import bme.restaurant.dao.User;
import bme.restaurant.repository.BookingRepository;
import bme.restaurant.repository.DrinkRepository;
import bme.restaurant.repository.FoodRepository;
import bme.restaurant.repository.IngredientRepository;
import bme.restaurant.repository.TableOrderRepository;
import bme.restaurant.repository.TableRepository;
import bme.restaurant.repository.UserRepository;

@Component
public class DataSeeder implements CommandLineRunner {

	@Autowired
	private IngredientRepository ingredientRepo;

	@Autowired
	private FoodRepository foodRepo;

	@Autowired
	private DrinkRepository drinkRepo;

	@Autowired
	private TableRepository tableRepo;

	@Autowired
	private TableOrderRepository tableOrderRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BookingRepository bookingRepo;

	@Override
	public void run(String... args) throws Exception {
		seed();
	}

	private void seed() {
		var now = LocalDateTime.now();

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
		var tables = List.of(
			new Table(1, 4, "free"),
			new Table(2, 3, "free"),
			new Table(3, 8, "free"),
			new Table(4, 1, "free"),
			new Table(5, 2, "free"),
			new Table(6, 2, "free"),
			new Table(7, 5, "free"),
			new Table(8, 6, "free"),
			new Table(12, 4, "free"),
			new Table(42, 6, "free")
		);

		if (tableRepo.count() == 0) {
			for (var table : tables) {
				table = tableRepo.save(table);
			}
		}

		// table Orders
		FoodOrderItem meatWithPotatoOrder1 = new FoodOrderItem(meatWithPotato, 2);
		DrinkOrderItem iceTeaGreenOrder1 = new DrinkOrderItem(iceTeaGreen, 2);

		Order order1 = new Order(
			List.of(meatWithPotatoOrder1), 
			List.of(iceTeaGreenOrder1),
			"delivered",
			now.minusDays(2));
		
		TableOrder table42Order1 = new TableOrder(
			tables.get(3), 
			order1);

		if (tableOrderRepo.count() == 0) {
			table42Order1 = tableOrderRepo.save(table42Order1);
		}

		// customers
		// password check with this lib: BCrypt.checkpw("user_input_password", hashedPassword);

		User customer1 = new User(
			"Random Jóska", 
			"1112 Budapest Hangos utca 42", 
			"+36421112222", 
			"randomjoska@mail.hu",
			BCrypt.hashpw("1234", BCrypt.gensalt()), 
			"admin");

		if (userRepo.count() == 0) {
			customer1 = userRepo.save(customer1);
		}

		// bookings

		var today_18_00 = now.withHour(18).withMinute(0).withSecond(0).withNano(0);

		var booking1 = new Booking(
			tables.get(4),
			customer1,
			today_18_00,
			today_18_00.plusHours(2),
			"accepted", 
			tables.get(4).getCapacity() - 1);
		
		var booking2 = new Booking(
			tables.get(6),
			customer1,
			today_18_00.plusDays(7),
			today_18_00.plusDays(7).plusHours(2),
			"accepted", 
			tables.get(6).getCapacity());

		if (bookingRepo.count() == 0) {
			booking1 = bookingRepo.save(booking1);
			booking2 = bookingRepo.save(booking2);
		}
	}
}
