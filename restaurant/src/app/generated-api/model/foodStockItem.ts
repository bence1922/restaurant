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


export interface FoodStockItem { 
    name: string;
    quantity: number;
    unit: FoodStockItem.UnitEnum;
}
export namespace FoodStockItem {
    export type UnitEnum = 'kg' | 'liter' | 'g' | 'dkg' | 'dl';
    export const UnitEnum = {
        Kg: 'kg' as UnitEnum,
        Liter: 'liter' as UnitEnum,
        G: 'g' as UnitEnum,
        Dkg: 'dkg' as UnitEnum,
        Dl: 'dl' as UnitEnum
    };
}


