package bme.restaurant.dto;

import java.net.URI;
import java.util.Objects;
import bme.restaurant.dto.OrderDTO;
import bme.restaurant.dto.TableDTO;
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
 * TableOrderDTO
 */

@JsonTypeName("TableOrder")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class TableOrderDTO {

  private String id;

  private TableDTO table;

  private OrderDTO order;

  public TableOrderDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TableOrderDTO(String id, TableDTO table, OrderDTO order) {
    this.id = id;
    this.table = table;
    this.order = order;
  }

  public TableOrderDTO id(String id) {
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

  public TableOrderDTO table(TableDTO table) {
    this.table = table;
    return this;
  }

  /**
   * Get table
   * @return table
  */
  @NotNull @Valid 
  @Schema(name = "table", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("table")
  public TableDTO getTable() {
    return table;
  }

  public void setTable(TableDTO table) {
    this.table = table;
  }

  public TableOrderDTO order(OrderDTO order) {
    this.order = order;
    return this;
  }

  /**
   * Get order
   * @return order
  */
  @NotNull @Valid 
  @Schema(name = "order", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("order")
  public OrderDTO getOrder() {
    return order;
  }

  public void setOrder(OrderDTO order) {
    this.order = order;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TableOrderDTO tableOrder = (TableOrderDTO) o;
    return Objects.equals(this.id, tableOrder.id) &&
        Objects.equals(this.table, tableOrder.table) &&
        Objects.equals(this.order, tableOrder.order);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, table, order);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TableOrderDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    table: ").append(toIndentedString(table)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
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

