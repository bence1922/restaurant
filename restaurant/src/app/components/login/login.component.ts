import { Component, EventEmitter, Inject, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CardModule } from 'primeng/card';
import { Router } from '@angular/router';
import { UserService } from '../../generated-api/api/user.service';
import { User } from '../../generated-api/model/user';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, CardModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  username: string = '';
  password: string = '';



  constructor(
    private router: Router,
    private userService: UserService,
  ) {}

  submitLoginForm(form: any) {
    if (form.valid) {
      const user = {name: this.username, password: this.password} as User;
      // Call your login API with this.username and this.password
      // Example: this.authService.login(this.username, this.password);
      this.userService.loginUser(user).subscribe(
        (roles: string[]) => {
          console.log(roles);
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
