package bme.restaurant.dto;

import java.net.URI;
import java.util.Objects;
import bme.restaurant.dto.TableDTO;
import bme.restaurant.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
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
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-23T00:54:23.413633600+01:00[Europe/Budapest]")
public class BookingDTO {

  private String id;

  private TableDTO table;

  private UserDTO customer;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startingDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime endingDate;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    PENDING("pending"),
    
    ACCEPTED("accepted");

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

  private Integer peopleCount;

  public BookingDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public BookingDTO(String id, TableDTO table, UserDTO customer, OffsetDateTime startingDate, OffsetDateTime endingDate, StatusEnum status, Integer peopleCount) {
    this.id = id;
    this.table = table;
    this.customer = customer;
    this.startingDate = startingDate;
    this.endingDate = endingDate;
    this.status = status;
    this.peopleCount = peopleCount;
  }

  public BookingDTO id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @NotNull 
  @Schema(name = "id", example = "ObjectId('6544cd596955fe0a1c04fba9')", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public BookingDTO customer(UserDTO customer) {
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

  public BookingDTO status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @NotNull 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public BookingDTO peopleCount(Integer peopleCount) {
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
    BookingDTO booking = (BookingDTO) o;
    return Objects.equals(this.id, booking.id) &&
        Objects.equals(this.table, booking.table) &&
        Objects.equals(this.customer, booking.customer) &&
        Objects.equals(this.startingDate, booking.startingDate) &&
        Objects.equals(this.endingDate, booking.endingDate) &&
        Objects.equals(this.status, booking.status) &&
        Objects.equals(this.peopleCount, booking.peopleCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, table, customer, startingDate, endingDate, status, peopleCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookingDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    table: ").append(toIndentedString(table)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    startingDate: ").append(toIndentedString(startingDate)).append("\n");
    sb.append("    endingDate: ").append(toIndentedString(endingDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

