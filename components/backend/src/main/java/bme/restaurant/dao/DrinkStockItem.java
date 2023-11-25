package bme.restaurant.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import bme.restaurant.dto.DrinkStockItemDTO;

@Document(collection = "drink_stock")
public class DrinkStockItem {
    @Id
    private String id;

    @DocumentReference
    private Drink drink;

    private int quantity;

    public DrinkStockItem(
            Drink drink,
            int quantity) {
        super();  
        this.drink = drink;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public DrinkStockItemDTO toDTO() {
        DrinkStockItemDTO drinkStockItemDTO = new DrinkStockItemDTO(this.getDrink().getName(), this.quantity);
        drinkStockItemDTO.setId(id);
        return drinkStockItemDTO;
    }
}
