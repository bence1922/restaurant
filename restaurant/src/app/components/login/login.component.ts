import { Component, EventEmitter, Inject, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CardModule } from 'primeng/card';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/generated-api/api/auth.service';
import { ButtonModule } from 'primeng/button';
import { UserLogin, UserSession } from 'src/app/generated-api';
import { StoreUserService } from 'src/app/generated-api/api/store.service';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, CardModule, ButtonModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  username: string = '';
  password: string = '';



  constructor(
    private router: Router,
    private storeUserService: StoreUserService,
    private authService: AuthService,
  ) {}

  submitLoginForm(form: any) {
    if (form.valid) {
      const userLogin = {name: this.username, password: this.password} as UserLogin;
      // Call your login API with this.username and this.password
      // Example: this.authService.login(this.username, this.password);
      this.authService.login(userLogin).subscribe(
        (userSession: UserSession) => {
          this.storeUserService.storeUser(userSession);
          this.router.navigate(['/']);
        },
        (error) => {
          console.log(error);
        }
      );
      console.log('Login API call');
    }
  }

  goToRegistration() {
    // Handle redirection to registration page or action here
    this.router.navigate(['/registration']);
  }
}
