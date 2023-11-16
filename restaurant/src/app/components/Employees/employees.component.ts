import { Component, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeroComponent } from '../Hero/hero.component';
import { Employee } from 'src/app/generated-api/model/employee';
import { DividerModule } from 'primeng/divider';
import { ButtonModule } from 'primeng/button';
import { EmployeeService } from 'src/app/generated-api';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-employees',
  standalone: true,
  imports: [CommonModule, HeroComponent, DividerModule, ButtonModule],
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.scss'],
})
export class EmployeesComponent implements OnInit, OnDestroy {
  getEmployeesSubscribtion?: Subscription;

  employees: Employee[] = [
    {name: 'Kiss József', role: 'waiter'},
    {name: 'Kiss Béla', role: 'waiter'},
    {name: 'Nagy József', role: 'manager'},
  ]

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.getEmployeesSubscribtion?.unsubscribe();
    this.getEmployeesSubscribtion = this.employeeService.getEmployees().subscribe(employees => this.employees = employees)
  }

  changeEmployee(employee: Employee){
    
  }

  addEmployee(){

  }

  ngOnDestroy(): void {
    this.getEmployeesSubscribtion?.unsubscribe();
  }

}
