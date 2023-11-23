package bme.restaurant.dto;

import java.net.URI;
import java.util.Objects;
import bme.restaurant.dto.DrinkDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * DrinkOrderItemDTO
 */

@JsonTypeName("DrinkOrderItem")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-23T22:27:38.107543100+01:00[Europe/Budapest]")
public class DrinkOrderItemDTO {

  private DrinkDTO drink;

  private Integer quantity;

  public DrinkOrderItemDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DrinkOrderItemDTO(DrinkDTO drink, Integer quantity) {
    this.drink = drink;
    this.quantity = quantity;
  }

  public DrinkOrderItemDTO drink(DrinkDTO drink) {
    this.drink = drink;
    return this;
  }

  /**
   * Get drink
   * @return drink
  */
  @NotNull @Valid 
  @Schema(name = "drink", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("drink")
  public DrinkDTO getDrink() {
    return drink;
  }

  public void setDrink(DrinkDTO drink) {
    this.drink = drink;
  }

  public DrinkOrderItemDTO quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
  */
  @NotNull 
  @Schema(name = "quantity", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("quantity")
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DrinkOrderItemDTO drinkOrderItem = (DrinkOrderItemDTO) o;
    return Objects.equals(this.drink, drinkOrderItem.drink) &&
        Objects.equals(this.quantity, drinkOrderItem.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(drink, quantity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DrinkOrderItemDTO {\n");
    sb.append("    drink: ").append(toIndentedString(drink)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

