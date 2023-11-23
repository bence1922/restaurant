/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package bme.restaurant.api;

import bme.restaurant.dto.UserLoginDTO;
import bme.restaurant.dto.UserSessionDTO;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-23T22:27:38.107543100+01:00[Europe/Budapest]")
@Validated
@Tag(name = "user", description = "the user API")
public interface LoginApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /login : User login
     *
     * @param userLoginDTO  (required)
     * @return User successfully logged in (status code 200)
     *         or Unauthorized (status code 401)
     *         or Invalid request (status code 400)
     */
    @Operation(
        operationId = "login",
        summary = "User login",
        tags = { "user" },
        responses = {
            @ApiResponse(responseCode = "200", description = "User successfully logged in", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UserSessionDTO.class))
            }),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "400", description = "Invalid request")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/login",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<UserSessionDTO> login(
        @Parameter(name = "UserLoginDTO", description = "", required = true) @Valid @RequestBody UserLoginDTO userLoginDTO
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"role\" : \"admin\", \"id\" : \"ObjectId('6544cd596955fe0a1c04fba9')\", \"user\" : { \"mobil\" : \"36709834234\", \"address\" : \"Budapest Lakatos utca 6.\", \"name\" : \"Gipsz Jakap\", \"id\" : \"ObjectId('6544cd596955fe0a1c04fba9')\", \"email\" : \"gipsz@jakab.com\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
