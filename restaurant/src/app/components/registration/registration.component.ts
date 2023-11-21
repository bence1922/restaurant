import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

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
  ) {}

  submitLoginForm(form: any) {
    if (form.valid) {
      // Call your login API with this.username and this.password
      // Example: this.authService.login(this.username, this.password);
      console.log('Registration API call');
    }
  }

  goToLogin() {
    // Handle redirection to registration page or action here
    this.router.navigate(['/login']);
  }
}
