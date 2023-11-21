import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { User } from 'src/app/generated-api/model/user';
import { LoginComponent } from '../login/login.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule, LoginComponent],
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent{
  user: User | undefined;
  showLoginPopup: boolean = false;

  constructor(
    private router: Router,
  ) {}

  updateUserJogkor(user: User){ //Kívülről meg kell hívni, amikor bejelentkezik a user
    this.user = user;
  }

  redirectToLogin(){
    this.router.navigate(['/login']);
  }
}
