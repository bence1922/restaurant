/**
 * Swagger Restaurant
 * This is a sample Restaruant
 *
 * The version of the OpenAPI document: 1.0.1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
import { FoodRecipeInner } from './foodRecipeInner';


export interface Food { 
    id?: string;
    name: string;
    price: number;
    recipe?: Array<FoodRecipeInner>;
}
