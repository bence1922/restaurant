export * from './employee.service';
import { EmployeeService } from './employee.service';
export * from './table.service';
import { TableService } from './table.service';
export * from './tableOrder.service';
import { TableOrderService } from './tableOrder.service';
export * from './user.service';
import { UserService } from './user.service';
export const APIS = [EmployeeService, TableService, TableOrderService, UserService];
