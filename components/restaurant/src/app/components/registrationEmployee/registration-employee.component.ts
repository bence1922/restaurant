import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { UserRegister, User, EmployeeService } from 'src/app/generated-api';
import { ButtonModule } from 'primeng/button';

@Component({
  selector: 'app-registration-employee',
  standalone: true,
  imports: [CommonModule, FormsModule, ButtonModule],
  templateUrl: './registration-employee.component.html',
  styleUrls: ['./registration-employee.component.scss'],
})
export class RegistrationEmployeeComponent {
  username: string = '';
  mobile: string = '';
  email: string = '';
  address: string = '';
  password: string = '';
  password_again: string = '';

  constructor(
    private router: Router,
    private employeeService: EmployeeService,
  ) {
  }

  submitLoginForm(form: any) {
    if (form.valid) {
      if(this.password != this.password_again){
        console.log("Passwords don't match");
        return;
      }else{
        const user = {
          name: this.username, 
          mobil: this.mobile,
          email: this.email,
          address: this.address,
          password: this.password} as UserRegister;          
          this.employeeService.registerEmployee(user).subscribe((user: User) => {
            this.router.navigate(['/employees']);
        });
      }
   }
  }

  goToEmployees() {
    // Handle redirection to registration page or action here
    this.router.navigate(['/employees']);
  }
}
