/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package bme.restaurant.api;

import bme.restaurant.dto.DrinkStockItemDTO;
import bme.restaurant.dto.FoodStockItemDTO;
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
@Tag(name = "stock", description = "the stock API")
public interface StockApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /stock/drink : Create a new drink stock item
     *
     * @param drinkStockItemDTO  (required)
     * @return Drink stock item created successfully (status code 201)
     *         or Invalid input (status code 400)
     */
    @Operation(
        operationId = "createDrinkStockItem",
        summary = "Create a new drink stock item",
        responses = {
            @ApiResponse(responseCode = "201", description = "Drink stock item created successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = DrinkStockItemDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid input")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/stock/drink",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<DrinkStockItemDTO> createDrinkStockItem(
        @Parameter(name = "DrinkStockItemDTO", description = "", required = true) @Valid @RequestBody DrinkStockItemDTO drinkStockItemDTO
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"quantity\" : 1, \"name\" : \"coke\", \"id\" : \"id\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /stock/food : Create a new food stock item
     *
     * @param foodStockItemDTO  (required)
     * @return Food stock item created successfully (status code 201)
     *         or Invalid input (status code 400)
     */
    @Operation(
        operationId = "createFoodStockItem",
        summary = "Create a new food stock item",
        responses = {
            @ApiResponse(responseCode = "201", description = "Food stock item created successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = FoodStockItemDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid input")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/stock/food",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<FoodStockItemDTO> createFoodStockItem(
        @Parameter(name = "FoodStockItemDTO", description = "", required = true) @Valid @RequestBody FoodStockItemDTO foodStockItemDTO
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"unit\" : \"kg\", \"quantity\" : 1, \"name\" : \"hús\", \"id\" : \"id\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /stock/drink/{drinkStockItemId} : Delete a drink stock item
     *
     * @param drinkStockItemId ID of the drinkStockItem to retrieve/update/delete (required)
     * @return Drink stock item deleted successfully (status code 204)
     *         or Drink stock item not found (status code 404)
     */
    @Operation(
        operationId = "deleteDrinkStockItem",
        summary = "Delete a drink stock item",
        responses = {
            @ApiResponse(responseCode = "204", description = "Drink stock item deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Drink stock item not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/stock/drink/{drinkStockItemId}"
    )
    default ResponseEntity<Void> deleteDrinkStockItem(
        @Parameter(name = "drinkStockItemId", description = "ID of the drinkStockItem to retrieve/update/delete", required = true, in = ParameterIn.PATH) @PathVariable("drinkStockItemId") String drinkStockItemId
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /stock/food/{foodStockItemId} : Delete a food stock item
     *
     * @param foodStockItemId ID of the foodStockItem to retrieve/update/delete (required)
     * @return Food stock item deleted successfully (status code 204)
     *         or Food stock item not found (status code 404)
     */
    @Operation(
        operationId = "deleteFoodStockItem",
        summary = "Delete a food stock item",
        responses = {
            @ApiResponse(responseCode = "204", description = "Food stock item deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Food stock item not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/stock/food/{foodStockItemId}"
    )
    default ResponseEntity<Void> deleteFoodStockItem(
        @Parameter(name = "foodStockItemId", description = "ID of the foodStockItem to retrieve/update/delete", required = true, in = ParameterIn.PATH) @PathVariable("foodStockItemId") String foodStockItemId
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /stock/drink : Get all drink stock items
     *
     * @return Successful operation (status code 200)
     */
    @Operation(
        operationId = "getAllDrinkStockItems",
        summary = "Get all drink stock items",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DrinkStockItemDTO.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/stock/drink",
        produces = { "application/json" }
    )
    default ResponseEntity<List<DrinkStockItemDTO>> getAllDrinkStockItems(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"quantity\" : 1, \"name\" : \"coke\", \"id\" : \"id\" }, { \"quantity\" : 1, \"name\" : \"coke\", \"id\" : \"id\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /stock/food : Get all food stock items
     *
     * @return Successful operation (status code 200)
     */
    @Operation(
        operationId = "getAllFoodStockItems",
        summary = "Get all food stock items",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FoodStockItemDTO.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/stock/food",
        produces = { "application/json" }
    )
    default ResponseEntity<List<FoodStockItemDTO>> getAllFoodStockItems(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"unit\" : \"kg\", \"quantity\" : 1, \"name\" : \"hús\", \"id\" : \"id\" }, { \"unit\" : \"kg\", \"quantity\" : 1, \"name\" : \"hús\", \"id\" : \"id\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PATCH /stock/drink/{drinkStockItemId} : Partially update a drink stock item
     *
     * @param drinkStockItemId ID of the drinkStockItem to retrieve/update/delete (required)
     * @param name Name of the drink stock item to update (optional)
     * @param quantity New quantity of the drink stock item (optional)
     * @return Drink stock item partially updated successfully (status code 200)
     *         or Invalid input (status code 400)
     *         or Drink stock item not found (status code 404)
     */
    @Operation(
        operationId = "partiallyUpdateDrinkStockItem",
        summary = "Partially update a drink stock item",
        responses = {
            @ApiResponse(responseCode = "200", description = "Drink stock item partially updated successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = DrinkStockItemDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Drink stock item not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.PATCH,
        value = "/stock/drink/{drinkStockItemId}",
        produces = { "application/json" }
    )
    default ResponseEntity<DrinkStockItemDTO> partiallyUpdateDrinkStockItem(
        @Parameter(name = "drinkStockItemId", description = "ID of the drinkStockItem to retrieve/update/delete", required = true, in = ParameterIn.PATH) @PathVariable("drinkStockItemId") String drinkStockItemId,
        @Parameter(name = "name", description = "Name of the drink stock item to update", in = ParameterIn.QUERY) @Valid @RequestParam(value = "name", required = false) String name,
        @Parameter(name = "quantity", description = "New quantity of the drink stock item", in = ParameterIn.QUERY) @Valid @RequestParam(value = "quantity", required = false) Integer quantity
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"quantity\" : 1, \"name\" : \"coke\", \"id\" : \"id\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PATCH /stock/food/{foodStockItemId} : Partially update a food stock item
     *
     * @param foodStockItemId ID of the foodStockItem to retrieve/update/delete (required)
     * @param name Name of the food stock item to update (optional)
     * @param quantity New quantity of the food stock item (optional)
     * @param unit New unit of the food stock item (optional)
     * @return Food stock item partially updated successfully (status code 200)
     *         or Invalid input (status code 400)
     *         or Food stock item not found (status code 404)
     */
    @Operation(
        operationId = "partiallyUpdateFoodStockItem",
        summary = "Partially update a food stock item",
        responses = {
            @ApiResponse(responseCode = "200", description = "Food stock item partially updated successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = FoodStockItemDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Food stock item not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.PATCH,
        value = "/stock/food/{foodStockItemId}",
        produces = { "application/json" }
    )
    default ResponseEntity<FoodStockItemDTO> partiallyUpdateFoodStockItem(
        @Parameter(name = "foodStockItemId", description = "ID of the foodStockItem to retrieve/update/delete", required = true, in = ParameterIn.PATH) @PathVariable("foodStockItemId") String foodStockItemId,
        @Parameter(name = "name", description = "Name of the food stock item to update", in = ParameterIn.QUERY) @Valid @RequestParam(value = "name", required = false) String name,
        @Parameter(name = "quantity", description = "New quantity of the food stock item", in = ParameterIn.QUERY) @Valid @RequestParam(value = "quantity", required = false) Integer quantity,
        @Parameter(name = "unit", description = "New unit of the food stock item", in = ParameterIn.QUERY) @Valid @RequestParam(value = "unit", required = false) String unit
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"unit\" : \"kg\", \"quantity\" : 1, \"name\" : \"hús\", \"id\" : \"id\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}