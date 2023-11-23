/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package bme.restaurant.api;

import bme.restaurant.dto.UserDTO;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-23T16:23:47.906689958+01:00[Europe/Budapest]")
@Validated
@Tag(name = "user", description = "the user API")
public interface UserApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /user/{userId} : Delete user by ID
     *
     * @param userId The ID of the user (required)
     * @return Invalid ID supplied (status code 400)
     *         or User not found (status code 404)
     */
    @Operation(
        operationId = "deleteUserById",
        summary = "Delete user by ID",
        tags = { "user" },
        responses = {
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "User not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/user/{userId}"
    )
    default ResponseEntity<Void> deleteUserById(
        @Parameter(name = "userId", description = "The ID of the user", required = true, in = ParameterIn.PATH) @PathVariable("userId") String userId
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /user/{userId} : Get user by ID
     *
     * @param userId The ID of the user (required)
     * @return Successful operation (status code 200)
     *         or User not found (status code 404)
     */
    @Operation(
        operationId = "getUserById",
        summary = "Get user by ID",
        tags = { "user" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))
            }),
            @ApiResponse(responseCode = "404", description = "User not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/user/{userId}",
        produces = { "application/json" }
    )
    default ResponseEntity<UserDTO> getUserById(
        @Parameter(name = "userId", description = "The ID of the user", required = true, in = ParameterIn.PATH) @PathVariable("userId") String userId
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"mobil\" : \"36709834234\", \"address\" : \"Budapest Lakatos utca 6.\", \"name\" : \"Gipsz Jakap\", \"id\" : \"ObjectId('6544cd596955fe0a1c04fba9')\", \"email\" : \"gipsz@jakab.com\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /user/{userId} : Update user by ID
     *
     * @param userId The ID of the user (required)
     * @param userDTO  (required)
     * @return Successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or User not found (status code 404)
     *         or Validation exception (status code 405)
     */
    @Operation(
        operationId = "updateUserById",
        summary = "Update user by ID",
        tags = { "user" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/user/{userId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<UserDTO> updateUserById(
        @Parameter(name = "userId", description = "The ID of the user", required = true, in = ParameterIn.PATH) @PathVariable("userId") String userId,
        @Parameter(name = "UserDTO", description = "", required = true) @Valid @RequestBody UserDTO userDTO
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"mobil\" : \"36709834234\", \"address\" : \"Budapest Lakatos utca 6.\", \"name\" : \"Gipsz Jakap\", \"id\" : \"ObjectId('6544cd596955fe0a1c04fba9')\", \"email\" : \"gipsz@jakab.com\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
