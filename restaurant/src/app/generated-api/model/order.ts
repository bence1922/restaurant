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
import { DrinkOrderItem } from './drinkOrderItem';
import { FoodOrderItem } from './foodOrderItem';


export interface Order { 
    status?: Order.StatusEnum;
    date?: string;
    note?: string;
    rating?: number;
    foods: Array<FoodOrderItem>;
    drinks: Array<DrinkOrderItem>;
}
export namespace Order {
    export type StatusEnum = 'placed' | 'cooking' | 'delivering' | 'delivered';
    export const StatusEnum = {
        Placed: 'placed' as StatusEnum,
        Cooking: 'cooking' as StatusEnum,
        Delivering: 'delivering' as StatusEnum,
        Delivered: 'delivered' as StatusEnum
    };
}


