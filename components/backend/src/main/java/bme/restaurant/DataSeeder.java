package bme.restaurant;

import java.time.LocalDateTime;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import bme.restaurant.dao.Booking;
import bme.restaurant.dao.CustomerOrder;
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
import bme.restaurant.repository.CustomerOrderRepository;
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

	@Autowired
	private CustomerOrderRepository customerOrderRepo;

	@Override
	public void run(String... args) throws Exception {
		seed();
	}
	User customer1;
	Food meatWithPotato;
	private void seed() {
		seedUsers();
		seedIngredients();
		var now = LocalDateTime.now();

		// drinks
		Drink iceTeaGreen = new Drink("Green Ice Tea", 400, "hot drink");
		// Hot Drinks
		Drink coffee = new Drink("Coffee", 350, "hot drink");
		Drink tea = new Drink("Tea", 300, "hot drink");
		Drink hotChocolate = new Drink("Hot Chocolate", 400, "hot drink");
		Drink latte = new Drink("Latte", 450, "hot drink");
		Drink cappuccino = new Drink("Cappuccino", 400, "hot drink");

		// Soft Drinks
		Drink cola = new Drink("Cola", 500, "soft drink");
		Drink lemonade = new Drink("Lemonade", 450, "soft drink");
		Drink orangeJuice = new Drink("Orange Juice", 350, "soft drink");
		Drink rootBeer = new Drink("Root Beer", 400, "soft drink");
		Drink gingerAle = new Drink("Ginger Ale", 300, "soft drink");

		// Alcoholic Drinks
		Drink mojito = new Drink("Mojito", 350, "alcoholic drink");
		Drink margarita = new Drink("Margarita", 400, "alcoholic drink");
		Drink martini = new Drink("Martini", 450, "alcoholic drink");
		Drink whiskeySour = new Drink("Whiskey Sour", 380, "alcoholic drink");
		Drink daiquiri = new Drink("Daiquiri", 420, "alcoholic drink");

		var drinks = List.of(coffee, tea, hotChocolate, latte, cappuccino, cola, lemonade, orangeJuice, rootBeer, gingerAle,
        mojito, margarita, martini, whiskeySour, daiquiri, iceTeaGreen);
		
		saveEntitiesIfRepoIsEmpty(drinkRepo, drinks);

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
				new Table(42, 6, "free"));

		saveEntitiesIfRepoIsEmpty(tableRepo, tables);

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

		var tableOrders = List.of(table42Order1);

		saveEntitiesIfRepoIsEmpty(tableOrderRepo, tableOrders);

		// customer orders

		Order order2 = new Order(
				List.of(meatWithPotatoOrder1),
				List.of(iceTeaGreenOrder1),
				"delivered",
				now.minusDays(2));

		CustomerOrder customerOrder1 = new CustomerOrder(
				customer1,
				order2);

		var customerOrders = List.of(customerOrder1);

		saveEntitiesIfRepoIsEmpty(customerOrderRepo, customerOrders);

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

		var bookings = List.of(booking1, booking2);

		saveEntitiesIfRepoIsEmpty(bookingRepo, bookings);
	}

	public void seedUsers(){
		// customers

		User admin1 = new User(
				"admin",
				"",
				"",
				"admin@mail.hu",
				BCrypt.hashpw("1234", BCrypt.gensalt()),
				"admin");

		User employee1 = new User(
				"Worker Wick",
				"1112 Budapest Hangos street 42",
				"+36421112222",
				"workerwick@mail.com",
				BCrypt.hashpw("1234", BCrypt.gensalt()),
				"employee");
		User employee2 = new User(
				"Worker Victoria",
				"1112 Budapest Hangosabb street 42",
				"+36421112222",
				"workervitoria@mail.com",
				BCrypt.hashpw("1234", BCrypt.gensalt()),
				"employee");

		customer1 = new User(
				"Hungry Henry",
				"1112 Budapest Kossuth street 34",
				"+36421112222",
				"hungryhenry@mail.hu",
				BCrypt.hashpw("1234", BCrypt.gensalt()),
				"customer");
		User customer2 = new User(
				"Hungry Helga",
				"1112 Budapest Nagy street 34",
				"+36421352222",
				"hungryhelga@mail.hu",
				BCrypt.hashpw("1234", BCrypt.gensalt()),
				"customer");

		var users = List.of(admin1, employee1, employee2, customer1, customer2);

		saveEntitiesIfRepoIsEmpty(userRepo, users);
	}

	public void seedIngredients(){
		// ingredients
		Ingredient meat = new Ingredient("meat", "g");
		Ingredient potato = new Ingredient("potato", "kg");
		Ingredient salt = new Ingredient("salt", "g");
		Ingredient onion = new Ingredient("onion", "g");
		Ingredient sugar = new Ingredient("sugar", "g");
		Ingredient flour = new Ingredient("flour", "g");
		Ingredient rice = new Ingredient("rice", "dkg");
		Ingredient oil = new Ingredient("oil", "g");
		Ingredient tomato = new Ingredient("tomato", "g");
		Ingredient chicken = new Ingredient("chicken", "g");
		Ingredient garlic = new Ingredient("garlic", "g");
		Ingredient pepper = new Ingredient("pepper", "g");
		Ingredient cheese = new Ingredient("cheese", "dkg");
		Ingredient butter = new Ingredient("butter", "g");
		Ingredient egg = new Ingredient("egg", "unit");
		Ingredient milk = new Ingredient("milk", "liter");
		Ingredient vinegar = new Ingredient("vinegar", "dl");
		Ingredient lemon = new Ingredient("lemon", "unit");
		Ingredient pasta = new Ingredient("pasta", "g");
		Ingredient bread = new Ingredient("bread", "unit");
		Ingredient cinnamon = new Ingredient("cinnamon", "g");
		Ingredient nutmeg = new Ingredient("nutmeg", "g");
		Ingredient paprika = new Ingredient("paprika", "g");
		Ingredient basil = new Ingredient("basil", "g");
		Ingredient oregano = new Ingredient("oregano", "g");
		Ingredient thyme = new Ingredient("thyme", "g");
		Ingredient parsley = new Ingredient("parsley", "g");
		Ingredient rosemary = new Ingredient("rosemary", "g");
		Ingredient cilantro = new Ingredient("cilantro", "g");
		Ingredient cumin = new Ingredient("cumin", "g");
		Ingredient turmeric = new Ingredient("turmeric", "g");
		Ingredient bayLeaf = new Ingredient("bay leaf", "unit");
		Ingredient honey = new Ingredient("honey", "dl");
		Ingredient mustard = new Ingredient("mustard", "dl");
		Ingredient mayonnaise = new Ingredient("mayonnaise", "dl");
		Ingredient soySauce = new Ingredient("soy sauce", "dl");
		Ingredient WorcestershireSauce = new Ingredient("Worcestershire sauce", "dl");
		Ingredient ketchup = new Ingredient("ketchup", "dl");
		Ingredient almonds = new Ingredient("almonds", "g");
		Ingredient bacon = new Ingredient("bacon", "g");
		Ingredient bellPepper = new Ingredient("bell pepper", "unit");
		Ingredient broccoli = new Ingredient("broccoli", "unit");
		Ingredient carrot = new Ingredient("carrot", "unit");
		Ingredient cauliflower = new Ingredient("cauliflower", "unit");
		Ingredient cheddar = new Ingredient("cheddar", "g");
		Ingredient chickpeas = new Ingredient("chickpeas", "g");
		Ingredient chocolate = new Ingredient("chocolate", "g");
		Ingredient coconutMilk = new Ingredient("coconut milk", "dl");
		Ingredient cod = new Ingredient("cod", "g");
		Ingredient corn = new Ingredient("corn", "g");
		Ingredient cottageCheese = new Ingredient("cottage cheese", "g");
		Ingredient cranberries = new Ingredient("cranberries", "g");
		Ingredient cucumber = new Ingredient("cucumber", "unit");
		Ingredient curryPaste = new Ingredient("curry paste", "g");
		Ingredient dates = new Ingredient("dates", "g");
		Ingredient feta = new Ingredient("feta", "g");
		Ingredient fishSauce = new Ingredient("fish sauce", "dl");
		Ingredient ginger = new Ingredient("ginger", "g");
		Ingredient grapefruit = new Ingredient("grapefruit", "unit");
		Ingredient honeydew = new Ingredient("honeydew", "unit");
		Ingredient ice = new Ingredient("ice", "unit");
		Ingredient kale = new Ingredient("kale", "g");
		Ingredient lentils = new Ingredient("lentils", "g");
		Ingredient mango = new Ingredient("mango", "unit");
		Ingredient mapleSyrup = new Ingredient("maple syrup", "dl");
		Ingredient mint = new Ingredient("mint", "g");
		Ingredient mozzarella = new Ingredient("mozzarella", "g");
		Ingredient oats = new Ingredient("oats", "g");
		Ingredient orange = new Ingredient("orange", "unit");
		Ingredient peanutButter = new Ingredient("peanut butter", "g");
		Ingredient pineapple = new Ingredient("pineapple", "unit");
		Ingredient pistachios = new Ingredient("pistachios", "g");
		Ingredient quinoa = new Ingredient("quinoa", "g");
		Ingredient radish = new Ingredient("radish", "unit");
		Ingredient raspberries = new Ingredient("raspberries", "g");
		Ingredient salmon = new Ingredient("salmon", "g");
		Ingredient sausage = new Ingredient("sausage", "g");
		var ingredients = List.of( meat, potato, salt, onion, sugar, flour, rice, oil, tomato, chicken, garlic, pepper, cheese, butter, egg, milk, vinegar, lemon, 
			pasta, bread, cinnamon, nutmeg, paprika, basil, oregano, thyme, parsley, rosemary, cilantro, cumin, turmeric, bayLeaf, honey, 
			mustard, soySauce, WorcestershireSauce, ketchup, almonds, bacon, bellPepper, broccoli, carrot, cauliflower, cheddar, chickpeas, 
			chocolate, coconutMilk, cod, corn, cottageCheese, cranberries, cucumber, curryPaste, dates, feta, fishSauce, ginger, grapefruit, 
			honeydew, ice, kale, lentils, mango, mapleSyrup, mint, mozzarella, oats, orange, peanutButter, pineapple, pistachios, quinoa, 
			radish, raspberries, salmon, sausage, mayonnaise
		);

		saveEntitiesIfRepoIsEmpty(ingredientRepo, ingredients);
		// Recipe Lines for the existing ingredients
		RecipeLine chickenLine = new RecipeLine(chicken, 300);
		RecipeLine garlicLine = new RecipeLine(garlic, 10);
		RecipeLine pepperLine = new RecipeLine(pepper, 5);
		RecipeLine saltLine = new RecipeLine(salt, 5);

		RecipeLine potatoLine = new RecipeLine(potato, 200);
		RecipeLine onionLine = new RecipeLine(onion, 50);
		RecipeLine mayonnaiseLine = new RecipeLine(mayonnaise, 100);
		RecipeLine mustardLine = new RecipeLine(mustard, 20);

		RecipeLine breadLine = new RecipeLine(bread, 150);
		RecipeLine butterLine = new RecipeLine(butter, 50);
		RecipeLine parsleyLine = new RecipeLine(parsley, 5);

		RecipeLine pastaLine = new RecipeLine(pasta, 250);
		RecipeLine tomatoLine = new RecipeLine(tomato, 150);
		RecipeLine basilLine = new RecipeLine(basil, 10);

		RecipeLine eggLine = new RecipeLine(egg, 3);
		RecipeLine cheeseLine = new RecipeLine(cheese, 100);
		RecipeLine bellPepperLine = new RecipeLine(bellPepper, 50);

		RecipeLine riceLine = new RecipeLine(rice, 300);

		RecipeLine milkLine = new RecipeLine(milk, 200);
		RecipeLine flourLine = new RecipeLine(flour, 300);
		RecipeLine sugarLine = new RecipeLine(sugar, 150);
		RecipeLine chocolateLine = new RecipeLine(chocolate, 100);
		RecipeLine carrotLine = new RecipeLine(carrot, 80);
		RecipeLine cauliflowerLine = new RecipeLine(cauliflower, 100);
		RecipeLine broccoliLine = new RecipeLine(broccoli, 120);

		// Basic foods using the existing ingredients
		Food food1 = new Food("Grilled Chicken", 800, "main course", List.of(chickenLine, garlicLine, pepperLine, saltLine));
		Food food2 = new Food("Potato Salad", 600, "side dish", List.of(potatoLine, onionLine, mayonnaiseLine, mustardLine));
		Food food3 = new Food("Garlic Bread", 400, "side dish", List.of(breadLine, garlicLine, butterLine, parsleyLine));
		Food food4 = new Food("Tomato Pasta", 900, "main course", List.of(pastaLine, tomatoLine, garlicLine, basilLine));
		Food food5 = new Food("Omelette", 500, "main course", List.of(eggLine, cheeseLine, onionLine, bellPepperLine));
		Food food6 = new Food("Rice Pilaf", 700, "side dish", List.of(riceLine, onionLine, garlicLine, chickenLine));
		Food food7 = new Food("Mashed Potatoes", 450, "side dish", List.of(potatoLine, butterLine, milkLine, saltLine));
		Food food8 = new Food("Vegetable Soup", 650, "soup", List.of(onionLine, carrotLine, cauliflowerLine, broccoliLine));
		Food food9 = new Food("Cheese Sandwich", 550, "main course", List.of(breadLine, cheeseLine, butterLine, tomatoLine));
		Food food10 = new Food("Chocolate Cake", 750, "dessert", List.of(flourLine, sugarLine, chocolateLine, butterLine));
		
		RecipeLine meatLine = new RecipeLine(meat, 200);
		meatWithPotato = new Food(
				"Meat with potato",
				3000,
				"main course",
				List.of(meatLine, potatoLine));
		var foods = List.of(
			meatWithPotato, food1, food2, food3, food4, food5, food6, food7, food8, food9,
			food10
		);
		saveEntitiesIfRepoIsEmpty(foodRepo, foods);
	}
	private <T, ID> void saveEntitiesIfRepoIsEmpty(MongoRepository<T, ID> repository, List<T> entities) {
    if (repository.count() == 0) {
        for (T entity : entities) {
            repository.save(entity);
        }
    }
}
}
