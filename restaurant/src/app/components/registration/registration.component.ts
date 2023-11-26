import { Component, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/generated-api/api/auth.service';
import { CustomerService, UserRegister, User, EmployeeService } from 'src/app/generated-api';
import { StoreUserService } from 'src/app/generated-api/api/store.service';
import { ButtonModule } from 'primeng/button';

@Component({
  selector: 'app-registration',
  standalone: true,
  imports: [CommonModule, FormsModule, ButtonModule],
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss'],
})
export class RegistrationComponent {
  username: string = '';
  mobile: string = '';
  email: string = '';
  address: string = '';
  password: string = '';
  password_again: string = '';

  constructor(
    private router: Router,
    private customerService: CustomerService,
    private storeUserService: StoreUserService,
    private authService: AuthService,

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
          this.customerService.registerCustomer(user).subscribe((user: User) => {
            this.authService.login({name: user.name, password: this.password} as UserRegister).subscribe((userSession) => {
            this.storeUserService.storeUser(userSession);
            this.router.navigate(['/']);
            });
        });
      }
   }
  }

  goToLogin() {
    // Handle redirection to registration page or action here
    this.router.navigate(['/login']);
  }
}
