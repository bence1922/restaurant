package bme.restaurant.dao;

import bme.restaurant.dto.DrinkDTO;

public class Drink {
    private String id;

    private String name;

    private int price;

    private String type;

    public Drink(
            String name,
            int price,
            String type) {
        super();  
        this.name = name;
        this.price = price;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public DrinkDTO toDTO() {
        var dto = new DrinkDTO();
        dto.setId(id);
        dto.setName(name);
        dto.setPrice(price);
        dto.setType(type); 
        return dto;
    }
}
