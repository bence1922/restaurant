import { Component, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeroComponent } from '../Hero/hero.component';
import { Employee } from 'src/app/generated-api/model/employee';
import { DividerModule } from 'primeng/divider';
import { ButtonModule } from 'primeng/button';
import { EmployeeService, User } from 'src/app/generated-api';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employees',
  standalone: true,
  imports: [CommonModule, HeroComponent, DividerModule, ButtonModule],
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.scss'],
})
export class EmployeesComponent implements OnInit, OnDestroy {
  getEmployeesSubscribtion?: Subscription;

  employees: User[] = [];


  constructor(private employeeService: EmployeeService,
              private router: Router,
    ) { }

  ngOnInit(): void {
    this.getEmployeesSubscribtion?.unsubscribe();
    this.getEmployeesSubscribtion = this.employeeService.getEmployees().subscribe(employees => this.employees = employees)
  }

  changeEmployee(employee: User){
    
  }

  addEmployee(){
    this.router.navigate(['/registration_employees']);
  }

  ngOnDestroy(): void {
    this.getEmployeesSubscribtion?.unsubscribe();
  }

}
