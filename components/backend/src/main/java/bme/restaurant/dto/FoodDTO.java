package bme.restaurant.dto;

import java.net.URI;
import java.util.Objects;
import bme.restaurant.dto.FoodRecipeInnerDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * FoodDTO
 */

@JsonTypeName("Food")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class FoodDTO {

  private String id;

  private String name;

  private String type;

  private Integer price;

  @Valid
  private List<@Valid FoodRecipeInnerDTO> recipe;

  public FoodDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FoodDTO(String id, String name, String type, Integer price) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.price = price;
  }

  public FoodDTO id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @NotNull 
  @Schema(name = "id", example = "6544cd596955fe0a1c04fba9", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public FoodDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "Hamburger", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FoodDTO type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @NotNull 
  @Schema(name = "type", example = "Főétel", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public FoodDTO price(Integer price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  @NotNull 
  @Schema(name = "price", example = "400", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("price")
  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public FoodDTO recipe(List<@Valid FoodRecipeInnerDTO> recipe) {
    this.recipe = recipe;
    return this;
  }

  public FoodDTO addRecipeItem(FoodRecipeInnerDTO recipeItem) {
    if (this.recipe == null) {
      this.recipe = new ArrayList<>();
    }
    this.recipe.add(recipeItem);
    return this;
  }

  /**
   * Get recipe
   * @return recipe
  */
  @Valid 
  @Schema(name = "recipe", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("recipe")
  public List<@Valid FoodRecipeInnerDTO> getRecipe() {
    return recipe;
  }

  public void setRecipe(List<@Valid FoodRecipeInnerDTO> recipe) {
    this.recipe = recipe;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FoodDTO food = (FoodDTO) o;
    return Objects.equals(this.id, food.id) &&
        Objects.equals(this.name, food.name) &&
        Objects.equals(this.type, food.type) &&
        Objects.equals(this.price, food.price) &&
        Objects.equals(this.recipe, food.recipe);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, type, price, recipe);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FoodDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    recipe: ").append(toIndentedString(recipe)).append("\n");
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

