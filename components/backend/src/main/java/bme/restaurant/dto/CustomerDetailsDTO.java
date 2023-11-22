package bme.restaurant.dto;

import java.net.URI;
import java.util.Objects;
import bme.restaurant.dto.OrderDTO;
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
 * CustomerDetailsDTO
 */

@JsonTypeName("CustomerDetails")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-21T18:28:48.793104700+01:00[Europe/Budapest]")
public class CustomerDetailsDTO {

  private String userId;

  private String name;

  private String email;

  private String mobil;

  private String address;

  private String company;

  private String tax;

  private Integer points;

  @Valid
  private List<@Valid OrderDTO> orders;

  public CustomerDetailsDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CustomerDetailsDTO(String name) {
    this.name = name;
  }

  public CustomerDetailsDTO userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  */
  
  @Schema(name = "userId", example = "ObjectId('6544cd596955fe0a1c04fba9')", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userId")
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public CustomerDetailsDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "Gipsz Jakap", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CustomerDetailsDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  
  @Schema(name = "email", example = "gipsz@jakab.com", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CustomerDetailsDTO mobil(String mobil) {
    this.mobil = mobil;
    return this;
  }

  /**
   * Get mobil
   * @return mobil
  */
  
  @Schema(name = "mobil", example = "36709834234", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("mobil")
  public String getMobil() {
    return mobil;
  }

  public void setMobil(String mobil) {
    this.mobil = mobil;
  }

  public CustomerDetailsDTO address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  */
  
  @Schema(name = "address", example = "Budapest Lakatos utca 6.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("address")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public CustomerDetailsDTO company(String company) {
    this.company = company;
    return this;
  }

  /**
   * Get company
   * @return company
  */
  
  @Schema(name = "company", example = "Gipsz Kft.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("company")
  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public CustomerDetailsDTO tax(String tax) {
    this.tax = tax;
    return this;
  }

  /**
   * Get tax
   * @return tax
  */
  
  @Schema(name = "tax", example = "3424-321-323", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tax")
  public String getTax() {
    return tax;
  }

  public void setTax(String tax) {
    this.tax = tax;
  }

  public CustomerDetailsDTO points(Integer points) {
    this.points = points;
    return this;
  }

  /**
   * Get points
   * @return points
  */
  
  @Schema(name = "points", example = "100", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("points")
  public Integer getPoints() {
    return points;
  }

  public void setPoints(Integer points) {
    this.points = points;
  }

  public CustomerDetailsDTO orders(List<@Valid OrderDTO> orders) {
    this.orders = orders;
    return this;
  }

  public CustomerDetailsDTO addOrdersItem(OrderDTO ordersItem) {
    if (this.orders == null) {
      this.orders = new ArrayList<>();
    }
    this.orders.add(ordersItem);
    return this;
  }

  /**
   * Get orders
   * @return orders
  */
  @Valid 
  @Schema(name = "orders", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("orders")
  public List<@Valid OrderDTO> getOrders() {
    return orders;
  }

  public void setOrders(List<@Valid OrderDTO> orders) {
    this.orders = orders;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerDetailsDTO customerDetails = (CustomerDetailsDTO) o;
    return Objects.equals(this.userId, customerDetails.userId) &&
        Objects.equals(this.name, customerDetails.name) &&
        Objects.equals(this.email, customerDetails.email) &&
        Objects.equals(this.mobil, customerDetails.mobil) &&
        Objects.equals(this.address, customerDetails.address) &&
        Objects.equals(this.company, customerDetails.company) &&
        Objects.equals(this.tax, customerDetails.tax) &&
        Objects.equals(this.points, customerDetails.points) &&
        Objects.equals(this.orders, customerDetails.orders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, name, email, mobil, address, company, tax, points, orders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerDetailsDTO {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    mobil: ").append(toIndentedString(mobil)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
    sb.append("    tax: ").append(toIndentedString(tax)).append("\n");
    sb.append("    points: ").append(toIndentedString(points)).append("\n");
    sb.append("    orders: ").append(toIndentedString(orders)).append("\n");
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

