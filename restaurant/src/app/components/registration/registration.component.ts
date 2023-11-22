import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/generated-api/api/auth.service';
import { UserService } from 'src/app/generated-api/api/user.service';
import { User } from 'src/app/generated-api';

@Component({
  selector: 'app-registration',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss'],
})
export class RegistrationComponent {
  username: string = '';
  password: string = '';
  password_again: string = '';

  constructor(
    private router: Router,
    private userService: UserService,
    private authService: AuthService,

  ) {}

  submitLoginForm(form: any) {
    if (form.valid) {
      if(this.password != this.password_again){
        console.log("Passwords don't match");
        return;
      }else{
        const user = {name: this.username, password: this.password} as User;
        this.userService.registerUser(user).subscribe((user: User) => {
          this.authService.storeUser(user);
          this.router.navigate(['/']);
        });
      }
      console.log('Registration API call');
    }
  }

  goToLogin() {
    // Handle redirection to registration page or action here
    this.router.navigate(['/login']);
  }
}
