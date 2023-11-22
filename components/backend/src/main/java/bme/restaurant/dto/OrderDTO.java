package bme.restaurant.dto;

import java.net.URI;
import java.util.Objects;
import bme.restaurant.dto.DrinkOrderItemDTO;
import bme.restaurant.dto.FoodOrderItemDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * OrderDTO
 */

@JsonTypeName("Order")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-21T18:28:48.793104700+01:00[Europe/Budapest]")
public class OrderDTO {

  private String id;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    PLACED("placed"),
    
    COOKING("cooking"),
    
    DELIVERING("delivering"),
    
    DELIVERED("delivered");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StatusEnum status;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime date;

  private String note;

  @Valid
  private List<@Valid FoodOrderItemDTO> foods = new ArrayList<>();

  @Valid
  private List<@Valid DrinkOrderItemDTO> drinks = new ArrayList<>();

  public OrderDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public OrderDTO(List<@Valid FoodOrderItemDTO> foods, List<@Valid DrinkOrderItemDTO> drinks) {
    this.foods = foods;
    this.drinks = drinks;
  }

  public OrderDTO id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", example = "6544cd596955fe0a1c04fba9", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public OrderDTO status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public OrderDTO date(OffsetDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
  */
  @Valid 
  @Schema(name = "date", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("date")
  public OffsetDateTime getDate() {
    return date;
  }

  public void setDate(OffsetDateTime date) {
    this.date = date;
  }

  public OrderDTO note(String note) {
    this.note = note;
    return this;
  }

  /**
   * Get note
   * @return note
  */
  
  @Schema(name = "note", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("note")
  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public OrderDTO foods(List<@Valid FoodOrderItemDTO> foods) {
    this.foods = foods;
    return this;
  }

  public OrderDTO addFoodsItem(FoodOrderItemDTO foodsItem) {
    if (this.foods == null) {
      this.foods = new ArrayList<>();
    }
    this.foods.add(foodsItem);
    return this;
  }

  /**
   * Get foods
   * @return foods
  */
  @NotNull @Valid 
  @Schema(name = "foods", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("foods")
  public List<@Valid FoodOrderItemDTO> getFoods() {
    return foods;
  }

  public void setFoods(List<@Valid FoodOrderItemDTO> foods) {
    this.foods = foods;
  }

  public OrderDTO drinks(List<@Valid DrinkOrderItemDTO> drinks) {
    this.drinks = drinks;
    return this;
  }

  public OrderDTO addDrinksItem(DrinkOrderItemDTO drinksItem) {
    if (this.drinks == null) {
      this.drinks = new ArrayList<>();
    }
    this.drinks.add(drinksItem);
    return this;
  }

  /**
   * Get drinks
   * @return drinks
  */
  @NotNull @Valid 
  @Schema(name = "drinks", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("drinks")
  public List<@Valid DrinkOrderItemDTO> getDrinks() {
    return drinks;
  }

  public void setDrinks(List<@Valid DrinkOrderItemDTO> drinks) {
    this.drinks = drinks;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderDTO order = (OrderDTO) o;
    return Objects.equals(this.id, order.id) &&
        Objects.equals(this.status, order.status) &&
        Objects.equals(this.date, order.date) &&
        Objects.equals(this.note, order.note) &&
        Objects.equals(this.foods, order.foods) &&
        Objects.equals(this.drinks, order.drinks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, date, note, foods, drinks);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    note: ").append(toIndentedString(note)).append("\n");
    sb.append("    foods: ").append(toIndentedString(foods)).append("\n");
    sb.append("    drinks: ").append(toIndentedString(drinks)).append("\n");
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

