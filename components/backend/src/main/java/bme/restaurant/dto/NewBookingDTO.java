package bme.restaurant.dto;

import java.net.URI;
import java.util.Objects;
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
 * NewBookingDTO
 */

@JsonTypeName("NewBooking")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-23T22:27:38.107543100+01:00[Europe/Budapest]")
public class NewBookingDTO {

  private Integer tableNumber;

  private String customerId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startingDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime endingDate;

  private Integer peopleCount;

  public NewBookingDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public NewBookingDTO(Integer tableNumber, String customerId, OffsetDateTime startingDate, OffsetDateTime endingDate, Integer peopleCount) {
    this.tableNumber = tableNumber;
    this.customerId = customerId;
    this.startingDate = startingDate;
    this.endingDate = endingDate;
    this.peopleCount = peopleCount;
  }

  public NewBookingDTO tableNumber(Integer tableNumber) {
    this.tableNumber = tableNumber;
    return this;
  }

  /**
   * Get tableNumber
   * @return tableNumber
  */
  @NotNull 
  @Schema(name = "table-number", example = "3", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("table-number")
  public Integer getTableNumber() {
    return tableNumber;
  }

  public void setTableNumber(Integer tableNumber) {
    this.tableNumber = tableNumber;
  }

  public NewBookingDTO customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Get customerId
   * @return customerId
  */
  @NotNull 
  @Schema(name = "customer-id", example = "6544cd596955fe0a1c04fba9", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("customer-id")
  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public NewBookingDTO startingDate(OffsetDateTime startingDate) {
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

  public NewBookingDTO endingDate(OffsetDateTime endingDate) {
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

  public NewBookingDTO peopleCount(Integer peopleCount) {
    this.peopleCount = peopleCount;
    return this;
  }

  /**
   * Get peopleCount
   * @return peopleCount
  */
  @NotNull 
  @Schema(name = "peopleCount", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("peopleCount")
  public Integer getPeopleCount() {
    return peopleCount;
  }

  public void setPeopleCount(Integer peopleCount) {
    this.peopleCount = peopleCount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewBookingDTO newBooking = (NewBookingDTO) o;
    return Objects.equals(this.tableNumber, newBooking.tableNumber) &&
        Objects.equals(this.customerId, newBooking.customerId) &&
        Objects.equals(this.startingDate, newBooking.startingDate) &&
        Objects.equals(this.endingDate, newBooking.endingDate) &&
        Objects.equals(this.peopleCount, newBooking.peopleCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tableNumber, customerId, startingDate, endingDate, peopleCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewBookingDTO {\n");
    sb.append("    tableNumber: ").append(toIndentedString(tableNumber)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    startingDate: ").append(toIndentedString(startingDate)).append("\n");
    sb.append("    endingDate: ").append(toIndentedString(endingDate)).append("\n");
    sb.append("    peopleCount: ").append(toIndentedString(peopleCount)).append("\n");
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

