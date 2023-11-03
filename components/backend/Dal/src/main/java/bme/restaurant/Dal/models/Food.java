package bme.restaurant.Dal.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "foods")
public class Food {
    @Id
    private String id;

    private String name;

    private int price;

    private int type;

    private List<RecipeLine> recipe;

    public Food(
            String id,
            String name,
            int price,
            int type,
            List<RecipeLine> recipe) {
        super();
        this.id = id;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<RecipeLine> getRecipe() {
        return recipe;
    }

    public void setRecipe(List<RecipeLine> recipe) {
        this.recipe = recipe;
    }
}
