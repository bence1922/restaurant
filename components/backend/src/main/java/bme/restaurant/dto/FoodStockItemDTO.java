package bme.restaurant.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * FoodStockItemDTO
 */

@JsonTypeName("FoodStockItem")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-24T19:02:19.052817200+01:00[Europe/Budapest]")
public class FoodStockItemDTO {

  private String name;

  private Integer quantity;

  /**
   * Gets or Sets unit
   */
  public enum UnitEnum {
    KG("kg"),
    
    LITER("liter"),
    
    G("g"),
    
    DKG("dkg"),
    
    DL("dl");

    private String value;

    UnitEnum(String value) {
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
    public static UnitEnum fromValue(String value) {
      for (UnitEnum b : UnitEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private UnitEnum unit;

  public FoodStockItemDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FoodStockItemDTO(String name, Integer quantity, UnitEnum unit) {
    this.name = name;
    this.quantity = quantity;
    this.unit = unit;
  }

  public FoodStockItemDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "hús", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FoodStockItemDTO quantity(Integer quantity) {
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

  public FoodStockItemDTO unit(UnitEnum unit) {
    this.unit = unit;
    return this;
  }

  /**
   * Get unit
   * @return unit
  */
  @NotNull 
  @Schema(name = "unit", example = "kg", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("unit")
  public UnitEnum getUnit() {
    return unit;
  }

  public void setUnit(UnitEnum unit) {
    this.unit = unit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FoodStockItemDTO foodStockItem = (FoodStockItemDTO) o;
    return Objects.equals(this.name, foodStockItem.name) &&
        Objects.equals(this.quantity, foodStockItem.quantity) &&
        Objects.equals(this.unit, foodStockItem.unit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, quantity, unit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FoodStockItemDTO {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
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

