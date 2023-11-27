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


export interface Drink { 
    id: string;
    name: string;
    type: Drink.TypeEnum;
    price: number;
}
export namespace Drink {
    export type TypeEnum = 'soft drink' | 'hot drink' | 'alcoholic drink';
    export const TypeEnum = {
        SoftDrink: 'soft drink' as TypeEnum,
        HotDrink: 'hot drink' as TypeEnum,
        AlcoholicDrink: 'alcoholic drink' as TypeEnum
    };
}

