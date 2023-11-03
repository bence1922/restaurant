package bme.restaurant.Dal.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ingerdients")
public class Ingredient {
    @Id
    private String id;

    private String name;

    private String unit;

    public Ingredient() {
    }

    public Ingredient(
            String name,
            String unit) {
        super();  
        this.name = name;
        this.unit = unit;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
