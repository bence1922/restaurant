package bme.restaurant.dto;

import java.net.URI;
import java.util.Objects;
import bme.restaurant.dto.CustomerDTO;
import bme.restaurant.dto.TableDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * BookingDTO
 */

@JsonTypeName("Booking")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-05T11:07:26.572702200+01:00[Europe/Budapest]")
public class BookingDTO {

  private TableDTO table;

  private CustomerDTO customer;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startingDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime endingDate;

  public BookingDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public BookingDTO(TableDTO table, CustomerDTO customer, OffsetDateTime startingDate, OffsetDateTime endingDate) {
    this.table = table;
    this.customer = customer;
    this.startingDate = startingDate;
    this.endingDate = endingDate;
  }

  public BookingDTO table(TableDTO table) {
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

  public BookingDTO customer(CustomerDTO customer) {
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
  public CustomerDTO getCustomer() {
    return customer;
  }

  public void setCustomer(CustomerDTO customer) {
    this.customer = customer;
  }

  public BookingDTO startingDate(OffsetDateTime startingDate) {
    this.startingDate = startingDate;
    return this;
  }

  /**
   * Get startingDate
   * @return startingDate
  */
  @NotNull @Valid 
  @Schema(name = "startingDate", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("startingDate")
  public OffsetDateTime getStartingDate() {
    return startingDate;
  }

  public void setStartingDate(OffsetDateTime startingDate) {
    this.startingDate = startingDate;
  }

  public BookingDTO endingDate(OffsetDateTime endingDate) {
    this.endingDate = endingDate;
    return this;
  }

  /**
   * Get endingDate
   * @return endingDate
  */
  @NotNull @Valid 
  @Schema(name = "endingDate", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("endingDate")
  public OffsetDateTime getEndingDate() {
    return endingDate;
  }

  public void setEndingDate(OffsetDateTime endingDate) {
    this.endingDate = endingDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookingDTO booking = (BookingDTO) o;
    return Objects.equals(this.table, booking.table) &&
        Objects.equals(this.customer, booking.customer) &&
        Objects.equals(this.startingDate, booking.startingDate) &&
        Objects.equals(this.endingDate, booking.endingDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(table, customer, startingDate, endingDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookingDTO {\n");
    sb.append("    table: ").append(toIndentedString(table)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    startingDate: ").append(toIndentedString(startingDate)).append("\n");
    sb.append("    endingDate: ").append(toIndentedString(endingDate)).append("\n");
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

