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
 * FoodRecipeInnerDTO
 */

@JsonTypeName("Food_recipe_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class FoodRecipeInnerDTO {

  private String ingerient;

  /**
   * Gets or Sets unit
   */
  public enum UnitEnum {
    KG("kg"),
    
    LITER("liter"),
    
    G("g"),
    
    DKG("dkg"),
    
    DL("dl"),
    
    UNIT("unit");

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

  private Integer quantity;

  public FoodRecipeInnerDTO ingerient(String ingerient) {
    this.ingerient = ingerient;
    return this;
  }

  /**
   * Get ingerient
   * @return ingerient
  */
  
  @Schema(name = "ingerient", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ingerient")
  public String getIngerient() {
    return ingerient;
  }

  public void setIngerient(String ingerient) {
    this.ingerient = ingerient;
  }

  public FoodRecipeInnerDTO unit(UnitEnum unit) {
    this.unit = unit;
    return this;
  }

  /**
   * Get unit
   * @return unit
  */
  
  @Schema(name = "unit", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("unit")
  public UnitEnum getUnit() {
    return unit;
  }

  public void setUnit(UnitEnum unit) {
    this.unit = unit;
  }

  public FoodRecipeInnerDTO quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
  */
  
  @Schema(name = "quantity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    FoodRecipeInnerDTO foodRecipeInner = (FoodRecipeInnerDTO) o;
    return Objects.equals(this.ingerient, foodRecipeInner.ingerient) &&
        Objects.equals(this.unit, foodRecipeInner.unit) &&
        Objects.equals(this.quantity, foodRecipeInner.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ingerient, unit, quantity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FoodRecipeInnerDTO {\n");
    sb.append("    ingerient: ").append(toIndentedString(ingerient)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
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

