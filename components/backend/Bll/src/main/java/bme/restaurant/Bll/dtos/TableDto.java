package bme.restaurant.Bll.dtos;

import java.io.Serializable;

public class TableDto implements Serializable {
    private int number;

    public TableDto() {}
    public TableDto(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
}
