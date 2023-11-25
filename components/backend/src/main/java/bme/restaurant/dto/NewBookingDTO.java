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
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class NewBookingDTO {

  private Integer tableNumber;

  private String userId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startingDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime endingDate;

  private Integer peopleCount;

  private String note;

  public NewBookingDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public NewBookingDTO(Integer tableNumber, String userId, OffsetDateTime startingDate, OffsetDateTime endingDate, Integer peopleCount) {
    this.tableNumber = tableNumber;
    this.userId = userId;
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
  @Schema(name = "tableNumber", example = "3", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("tableNumber")
  public Integer getTableNumber() {
    return tableNumber;
  }

  public void setTableNumber(Integer tableNumber) {
    this.tableNumber = tableNumber;
  }

  public NewBookingDTO userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  */
  @NotNull 
  @Schema(name = "user-id", example = "6544cd596955fe0a1c04fba9", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("user-id")
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
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

  public NewBookingDTO note(String note) {
    this.note = note;
    return this;
  }

  /**
   * Get note
   * @return note
  */
  
  @Schema(name = "note", example = "az egyik fő egy kisbaba", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("note")
  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
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
        Objects.equals(this.userId, newBooking.userId) &&
        Objects.equals(this.startingDate, newBooking.startingDate) &&
        Objects.equals(this.endingDate, newBooking.endingDate) &&
        Objects.equals(this.peopleCount, newBooking.peopleCount) &&
        Objects.equals(this.note, newBooking.note);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tableNumber, userId, startingDate, endingDate, peopleCount, note);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewBookingDTO {\n");
    sb.append("    tableNumber: ").append(toIndentedString(tableNumber)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    startingDate: ").append(toIndentedString(startingDate)).append("\n");
    sb.append("    endingDate: ").append(toIndentedString(endingDate)).append("\n");
    sb.append("    peopleCount: ").append(toIndentedString(peopleCount)).append("\n");
    sb.append("    note: ").append(toIndentedString(note)).append("\n");
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

