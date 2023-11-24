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
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-24T19:02:19.052817200+01:00[Europe/Budapest]")
public class TableOrderDTO {

  private TableDTO table;

  private OrderDTO order;

  public TableOrderDTO table(TableDTO table) {
    this.table = table;
    return this;
  }

  /**
   * Get table
   * @return table
  */
  @Valid 
  @Schema(name = "table", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
  @Valid 
  @Schema(name = "order", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    return Objects.equals(this.table, tableOrder.table) &&
        Objects.equals(this.order, tableOrder.order);
  }

  @Override
  public int hashCode() {
    return Objects.hash(table, order);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TableOrderDTO {\n");
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

