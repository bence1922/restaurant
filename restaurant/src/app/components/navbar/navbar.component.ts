import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { User } from 'src/app/generated-api/model/user';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent{
  user: User | undefined;

  updateUserJogkor(user: User){ //Kívülről meg kell hívni, amikor bejelentkezik a user
    this.user = user;
  }
}
