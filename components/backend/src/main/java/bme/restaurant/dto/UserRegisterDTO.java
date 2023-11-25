package bme.restaurant.dto;

import java.net.URI;
import java.util.Objects;
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
 * UserRegisterDTO
 */

@JsonTypeName("UserRegister")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class UserRegisterDTO {

  private String name;

  private String email;

  private String mobil;

  private String address;

  private String password;

  public UserRegisterDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UserRegisterDTO(String name, String email, String mobil, String address, String password) {
    this.name = name;
    this.email = email;
    this.mobil = mobil;
    this.address = address;
    this.password = password;
  }

  public UserRegisterDTO name(String name) {
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

  public UserRegisterDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @NotNull 
  @Schema(name = "email", example = "gipsz@jakab.com", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserRegisterDTO mobil(String mobil) {
    this.mobil = mobil;
    return this;
  }

  /**
   * Get mobil
   * @return mobil
  */
  @NotNull 
  @Schema(name = "mobil", example = "36709834234", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("mobil")
  public String getMobil() {
    return mobil;
  }

  public void setMobil(String mobil) {
    this.mobil = mobil;
  }

  public UserRegisterDTO address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  */
  @NotNull 
  @Schema(name = "address", example = "Budapest Lakatos utca 6.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("address")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public UserRegisterDTO password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  */
  @NotNull 
  @Schema(name = "password", example = "password", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserRegisterDTO userRegister = (UserRegisterDTO) o;
    return Objects.equals(this.name, userRegister.name) &&
        Objects.equals(this.email, userRegister.email) &&
        Objects.equals(this.mobil, userRegister.mobil) &&
        Objects.equals(this.address, userRegister.address) &&
        Objects.equals(this.password, userRegister.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email, mobil, address, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserRegisterDTO {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    mobil: ").append(toIndentedString(mobil)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

