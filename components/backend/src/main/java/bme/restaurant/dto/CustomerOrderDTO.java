package bme.restaurant.dto;

import java.net.URI;
import java.util.Objects;
import bme.restaurant.dto.OrderDTO;
import bme.restaurant.dto.UserDTO;
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
 * CustomerOrderDTO
 */

@JsonTypeName("CustomerOrder")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class CustomerOrderDTO {

  private String id;

  private UserDTO customer;

  private OrderDTO order;

  public CustomerOrderDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CustomerOrderDTO(String id, UserDTO customer, OrderDTO order) {
    this.id = id;
    this.customer = customer;
    this.order = order;
  }

  public CustomerOrderDTO id(String id) {
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

  public CustomerOrderDTO customer(UserDTO customer) {
    this.customer = customer;
    return this;
  }

  /**
   * Get customer
   * @return customer
  */
  @NotNull @Valid 
  @Schema(name = "customer", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("customer")
  public UserDTO getCustomer() {
    return customer;
  }

  public void setCustomer(UserDTO customer) {
    this.customer = customer;
  }

  public CustomerOrderDTO order(OrderDTO order) {
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
    CustomerOrderDTO customerOrder = (CustomerOrderDTO) o;
    return Objects.equals(this.id, customerOrder.id) &&
        Objects.equals(this.customer, customerOrder.customer) &&
        Objects.equals(this.order, customerOrder.order);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, customer, order);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerOrderDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
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

