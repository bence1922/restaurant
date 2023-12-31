/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package bme.restaurant.api;

import bme.restaurant.dto.UserDTO;
import bme.restaurant.dto.UserRegisterDTO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "employee", description = "the employee API")
public interface EmployeeApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /employee : Get all employees
     *
     * @return Successful operation (status code 200)
     *         or Bad request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "getEmployees",
        summary = "Get all employees",
        tags = { "employee" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserDTO.class)))
            }),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        },
        security = {
            @SecurityRequirement(name = "sessionId")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/employee",
        produces = { "application/json" }
    )
    default ResponseEntity<List<UserDTO>> getEmployees(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"mobil\" : \"36709834234\", \"address\" : \"Budapest Lakatos utca 6.\", \"name\" : \"Gipsz Jakap\", \"id\" : \"6544cd596955fe0a1c04fba9\", \"email\" : \"gipsz@jakab.com\", \"points\" : 0 }, { \"mobil\" : \"36709834234\", \"address\" : \"Budapest Lakatos utca 6.\", \"name\" : \"Gipsz Jakap\", \"id\" : \"6544cd596955fe0a1c04fba9\", \"email\" : \"gipsz@jakab.com\", \"points\" : 0 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /employee : Register an employee
     *
     * @param userRegisterDTO  (required)
     * @return Employee succesfully registered (status code 201)
     *         or Bad request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or User with this name already exists (status code 409)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "registerEmployee",
        summary = "Register an employee",
        tags = { "employee" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Employee succesfully registered", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "409", description = "User with this name already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        },
        security = {
            @SecurityRequirement(name = "sessionId")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/employee",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<UserDTO> registerEmployee(
        @Parameter(name = "UserRegisterDTO", description = "", required = true) @Valid @RequestBody UserRegisterDTO userRegisterDTO
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"mobil\" : \"36709834234\", \"address\" : \"Budapest Lakatos utca 6.\", \"name\" : \"Gipsz Jakap\", \"id\" : \"6544cd596955fe0a1c04fba9\", \"email\" : \"gipsz@jakab.com\", \"points\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
