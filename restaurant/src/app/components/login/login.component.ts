import { Component, EventEmitter, Inject, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CardModule } from 'primeng/card';
import { Router } from '@angular/router';


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
  ) {}

  submitLoginForm(form: any) {
    if (form.valid) {
      // Call your login API with this.username and this.password
      // Example: this.authService.login(this.username, this.password);
      console.log('Login API call');
    }
  }

  goToRegistration() {
    // Handle redirection to registration page or action here
    this.router.navigate(['/registration']);
  }
}
