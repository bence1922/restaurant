/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package bme.restaurant.api;

import bme.restaurant.dto.BookingDTO;
import org.springframework.format.annotation.DateTimeFormat;
import bme.restaurant.dto.NewBookingDTO;
import java.time.OffsetDateTime;
import bme.restaurant.dto.TableDTO;
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
@Tag(name = "booking", description = "the booking API")
public interface BookingApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /booking : Book table
     *
     * @param newBookingDTO  (required)
     * @return Booking created successfully (status code 201)
     *         or Bad request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "bookTable",
        summary = "Book table",
        tags = { "booking" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Booking created successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = BookingDTO.class))
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
        method = RequestMethod.POST,
        value = "/booking",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<BookingDTO> bookTable(
        @Parameter(name = "NewBookingDTO", description = "", required = true) @Valid @RequestBody NewBookingDTO newBookingDTO
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"note\" : \"az egyik fő egy kisbaba\", \"endingDate\" : \"2000-01-23T04:56:07.000+00:00\", \"peopleCount\" : 0, \"id\" : \"6544cd596955fe0a1c04fba9\", \"startingDate\" : \"2000-01-23T04:56:07.000+00:00\", \"table\" : { \"number\" : 10, \"capacity\" : 10, \"status\" : \"booked\" }, \"customer\" : { \"mobil\" : \"36709834234\", \"address\" : \"Budapest Lakatos utca 6.\", \"name\" : \"Gipsz Jakap\", \"id\" : \"6544cd596955fe0a1c04fba9\", \"email\" : \"gipsz@jakab.com\", \"points\" : 0 }, \"status\" : \"pending\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PATCH /booking/{bookingId} : Update booking status
     *
     * @param bookingId  (required)
     * @param status  (required)
     * @return Successful operation (status code 200)
     *         or Bad request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "bookingStatusUpdate",
        summary = "Update booking status",
        tags = { "booking" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = BookingDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        },
        security = {
            @SecurityRequirement(name = "sessionId")
        }
    )
    @RequestMapping(
        method = RequestMethod.PATCH,
        value = "/booking/{bookingId}",
        produces = { "application/json" }
    )
    default ResponseEntity<BookingDTO> bookingStatusUpdate(
        @Parameter(name = "bookingId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("bookingId") String bookingId,
        @NotNull @Parameter(name = "status", description = "", required = true, in = ParameterIn.HEADER) @RequestHeader(value = "status", required = true) String status
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"note\" : \"az egyik fő egy kisbaba\", \"endingDate\" : \"2000-01-23T04:56:07.000+00:00\", \"peopleCount\" : 0, \"id\" : \"6544cd596955fe0a1c04fba9\", \"startingDate\" : \"2000-01-23T04:56:07.000+00:00\", \"table\" : { \"number\" : 10, \"capacity\" : 10, \"status\" : \"booked\" }, \"customer\" : { \"mobil\" : \"36709834234\", \"address\" : \"Budapest Lakatos utca 6.\", \"name\" : \"Gipsz Jakap\", \"id\" : \"6544cd596955fe0a1c04fba9\", \"email\" : \"gipsz@jakab.com\", \"points\" : 0 }, \"status\" : \"pending\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /booking/{bookingId} : Get booking
     *
     * @param bookingId  (required)
     * @return Successful operation (status code 200)
     *         or Invalid input (status code 405)
     */
    @Operation(
        operationId = "getBooking",
        summary = "Get booking",
        tags = { "booking" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = BookingDTO.class))
            }),
            @ApiResponse(responseCode = "405", description = "Invalid input")
        },
        security = {
            @SecurityRequirement(name = "sessionId")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/booking/{bookingId}",
        produces = { "application/json" }
    )
    default ResponseEntity<BookingDTO> getBooking(
        @Parameter(name = "bookingId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("bookingId") String bookingId
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"note\" : \"az egyik fő egy kisbaba\", \"endingDate\" : \"2000-01-23T04:56:07.000+00:00\", \"peopleCount\" : 0, \"id\" : \"6544cd596955fe0a1c04fba9\", \"startingDate\" : \"2000-01-23T04:56:07.000+00:00\", \"table\" : { \"number\" : 10, \"capacity\" : 10, \"status\" : \"booked\" }, \"customer\" : { \"mobil\" : \"36709834234\", \"address\" : \"Budapest Lakatos utca 6.\", \"name\" : \"Gipsz Jakap\", \"id\" : \"6544cd596955fe0a1c04fba9\", \"email\" : \"gipsz@jakab.com\", \"points\" : 0 }, \"status\" : \"pending\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /booking : Query bookings
     *
     * @param tableNumber  (optional)
     * @param customerName  (optional)
     * @param from  (optional)
     * @param to  (optional)
     * @return Successful operation (status code 200)
     *         or Bad request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "queryBookings",
        summary = "Query bookings",
        tags = { "booking" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BookingDTO.class)))
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
        value = "/booking",
        produces = { "application/json" }
    )
    default ResponseEntity<List<BookingDTO>> queryBookings(
        @Parameter(name = "tableNumber", description = "", in = ParameterIn.HEADER) @RequestHeader(value = "tableNumber", required = false) Integer tableNumber,
        @Parameter(name = "customer-name", description = "", in = ParameterIn.HEADER) @RequestHeader(value = "customer-name", required = false) String customerName,
        @Parameter(name = "from", description = "", in = ParameterIn.HEADER) @RequestHeader(value = "from", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime from,
        @Parameter(name = "to", description = "", in = ParameterIn.HEADER) @RequestHeader(value = "to", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime to
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"note\" : \"az egyik fő egy kisbaba\", \"endingDate\" : \"2000-01-23T04:56:07.000+00:00\", \"peopleCount\" : 0, \"id\" : \"6544cd596955fe0a1c04fba9\", \"startingDate\" : \"2000-01-23T04:56:07.000+00:00\", \"table\" : { \"number\" : 10, \"capacity\" : 10, \"status\" : \"booked\" }, \"customer\" : { \"mobil\" : \"36709834234\", \"address\" : \"Budapest Lakatos utca 6.\", \"name\" : \"Gipsz Jakap\", \"id\" : \"6544cd596955fe0a1c04fba9\", \"email\" : \"gipsz@jakab.com\", \"points\" : 0 }, \"status\" : \"pending\" }, { \"note\" : \"az egyik fő egy kisbaba\", \"endingDate\" : \"2000-01-23T04:56:07.000+00:00\", \"peopleCount\" : 0, \"id\" : \"6544cd596955fe0a1c04fba9\", \"startingDate\" : \"2000-01-23T04:56:07.000+00:00\", \"table\" : { \"number\" : 10, \"capacity\" : 10, \"status\" : \"booked\" }, \"customer\" : { \"mobil\" : \"36709834234\", \"address\" : \"Budapest Lakatos utca 6.\", \"name\" : \"Gipsz Jakap\", \"id\" : \"6544cd596955fe0a1c04fba9\", \"email\" : \"gipsz@jakab.com\", \"points\" : 0 }, \"status\" : \"pending\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /booking/table/avaible : Query avaible tables
     *
     * @param from  (required)
     * @param to  (required)
     * @return Successful operation (status code 200)
     *         or Bad request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "queryTablesForBooking",
        summary = "Query avaible tables",
        tags = { "booking" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TableDTO.class)))
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
        value = "/booking/table/avaible",
        produces = { "application/json" }
    )
    default ResponseEntity<List<TableDTO>> queryTablesForBooking(
        @NotNull @Parameter(name = "from", description = "", required = true, in = ParameterIn.HEADER) @RequestHeader(value = "from", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime from,
        @NotNull @Parameter(name = "to", description = "", required = true, in = ParameterIn.HEADER) @RequestHeader(value = "to", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime to
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"number\" : 10, \"capacity\" : 10, \"status\" : \"booked\" }, { \"number\" : 10, \"capacity\" : 10, \"status\" : \"booked\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
