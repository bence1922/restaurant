/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package bme.restaurant.api;

import bme.restaurant.dto.EmployeeDTO;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-12T22:48:22.982257200+01:00[Europe/Budapest]")
@Validated
@Tag(name = "employee", description = "the employee API")
public interface EmployeeApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /employee/{employeeId} : Delete an employee by ID
     *
     * @param employeeId The ID of the employee (required)
     * @return Invalid ID supplied (status code 400)
     *         or Employee not found (status code 404)
     */
    @Operation(
        operationId = "deleteEmployeeById",
        summary = "Delete an employee by ID",
        tags = { "employee" },
        responses = {
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Employee not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/employee/{employeeId}"
    )
    default ResponseEntity<Void> deleteEmployeeById(
        @Parameter(name = "employeeId", description = "The ID of the employee", required = true, in = ParameterIn.PATH) @PathVariable("employeeId") Integer employeeId
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /employee/{employeeId} : Get an employee by ID
     *
     * @param employeeId The ID of the employee (required)
     * @return Successful operation (status code 200)
     *         or Employee not found (status code 404)
     */
    @Operation(
        operationId = "getEmployeeById",
        summary = "Get an employee by ID",
        tags = { "employee" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeDTO.class))
            }),
            @ApiResponse(responseCode = "404", description = "Employee not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/employee/{employeeId}",
        produces = { "application/json" }
    )
    default ResponseEntity<EmployeeDTO> getEmployeeById(
        @Parameter(name = "employeeId", description = "The ID of the employee", required = true, in = ParameterIn.PATH) @PathVariable("employeeId") Integer employeeId
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"role\" : \"waiter\", \"name\" : \"6544cd596955fe0a1c04fba9\", \"userId\" : \"Nick Waiter\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /employee : Get all employees
     *
     * @return successful operation (status code 200)
     *         or Invalid status value (status code 400)
     */
    @Operation(
        operationId = "getEmployees",
        summary = "Get all employees",
        tags = { "employee" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = EmployeeDTO.class))),
                @Content(mediaType = "application/xml", array = @ArraySchema(schema = @Schema(implementation = EmployeeDTO.class)))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid status value")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/employee",
        produces = { "application/json", "application/xml" }
    )
    default ResponseEntity<List<EmployeeDTO>> getEmployees(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"role\" : \"waiter\", \"name\" : \"6544cd596955fe0a1c04fba9\", \"userId\" : \"Nick Waiter\" }, { \"role\" : \"waiter\", \"name\" : \"6544cd596955fe0a1c04fba9\", \"userId\" : \"Nick Waiter\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<null> <name>6544cd596955fe0a1c04fba9</name> <userId>Nick Waiter</userId> <role>aeiou</role> </null>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PATCH /employee/{employeeId} : Update attributes of an employee by ID
     *
     * @param employeeId The ID of the employee (required)
     * @param name New name for the employee (optional)
     * @param role New role for the employee (optional)
     * @return Successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Employee not found (status code 404)
     */
    @Operation(
        operationId = "patchEmployeeById",
        summary = "Update attributes of an employee by ID",
        tags = { "employee" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Employee not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.PATCH,
        value = "/employee/{employeeId}",
        produces = { "application/json" }
    )
    default ResponseEntity<EmployeeDTO> patchEmployeeById(
        @Parameter(name = "employeeId", description = "The ID of the employee", required = true, in = ParameterIn.PATH) @PathVariable("employeeId") Integer employeeId,
        @Parameter(name = "name", description = "New name for the employee", in = ParameterIn.QUERY) @Valid @RequestParam(value = "name", required = false) String name,
        @Parameter(name = "role", description = "New role for the employee", in = ParameterIn.QUERY) @Valid @RequestParam(value = "role", required = false) String role
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"role\" : \"waiter\", \"name\" : \"6544cd596955fe0a1c04fba9\", \"userId\" : \"Nick Waiter\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /employee/{employeeId} : Update an existing employee by ID
     *
     * @param employeeId The ID of the employee (required)
     * @param employeeDTO  (required)
     * @return Successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Employee not found (status code 404)
     *         or Validation exception (status code 405)
     */
    @Operation(
        operationId = "updateEmployeeById",
        summary = "Update an existing employee by ID",
        tags = { "employee" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Employee not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/employee/{employeeId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<EmployeeDTO> updateEmployeeById(
        @Parameter(name = "employeeId", description = "The ID of the employee", required = true, in = ParameterIn.PATH) @PathVariable("employeeId") Integer employeeId,
        @Parameter(name = "EmployeeDTO", description = "", required = true) @Valid @RequestBody EmployeeDTO employeeDTO
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"role\" : \"waiter\", \"name\" : \"6544cd596955fe0a1c04fba9\", \"userId\" : \"Nick Waiter\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}