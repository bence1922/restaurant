package bme.restaurant.dao;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import bme.restaurant.dto.FoodDTO;
import bme.restaurant.dto.FoodDTO.TypeEnum;

@Document(collection = "foods")
public class Food {
    @Id
    private String id;

    private String name;

    private int price;

    private String type;

    private List<RecipeLine> recipe;

    public Food(
            String name,
            int price,
            String type,
            List<RecipeLine> recipe) {
        super();
        this.name = name;
        this.price = price;
        this.type = type;
        this.recipe = recipe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<RecipeLine> getRecipe() {
        return recipe;
    }

    public void setRecipe(List<RecipeLine> recipe) {
        this.recipe = recipe;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public FoodDTO toDTO() {
        var foodDTO = new FoodDTO();
        foodDTO.setId(this.id);
        foodDTO.setName(this.name);
        foodDTO.setPrice(this.price);
        foodDTO.setType(TypeEnum.fromValue(this.type));
        foodDTO.setRecipe(recipe.stream().map((rl) -> rl.toDTO()).toList());
        return foodDTO;
    }

    public static Food fromDTO(FoodDTO food) {
        return new Food(
                food.getName(),
                food.getPrice(),
                food.getType().getValue(),
                food.getRecipe().stream().map((rl) -> RecipeLine.fromDTO(rl)).toList());
    }
}
