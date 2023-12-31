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
import { Table } from './table';
import { User } from './user';


export interface Booking { 
    id: string;
    table: Table;
    customer: User;
    startingDate: string;
    endingDate: string;
    status: Booking.StatusEnum;
    peopleCount: number;
    note?: string;
}
export namespace Booking {
    export type StatusEnum = 'pending' | 'accepted';
    export const StatusEnum = {
        Pending: 'pending' as StatusEnum,
        Accepted: 'accepted' as StatusEnum
    };
}


