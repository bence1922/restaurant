package bme.restaurant.dto;

import java.net.URI;
import java.util.Objects;
import bme.restaurant.dto.FoodDTO;
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
 * FoodOrderItemDTO
 */

@JsonTypeName("FoodOrderItem")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-23T22:27:38.107543100+01:00[Europe/Budapest]")
public class FoodOrderItemDTO {

  private FoodDTO food;

  private Integer quantity;

  public FoodOrderItemDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FoodOrderItemDTO(FoodDTO food, Integer quantity) {
    this.food = food;
    this.quantity = quantity;
  }

  public FoodOrderItemDTO food(FoodDTO food) {
    this.food = food;
    return this;
  }

  /**
   * Get food
   * @return food
  */
  @NotNull @Valid 
  @Schema(name = "food", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("food")
  public FoodDTO getFood() {
    return food;
  }

  public void setFood(FoodDTO food) {
    this.food = food;
  }

  public FoodOrderItemDTO quantity(Integer quantity) {
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
    FoodOrderItemDTO foodOrderItem = (FoodOrderItemDTO) o;
    return Objects.equals(this.food, foodOrderItem.food) &&
        Objects.equals(this.quantity, foodOrderItem.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(food, quantity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FoodOrderItemDTO {\n");
    sb.append("    food: ").append(toIndentedString(food)).append("\n");
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

