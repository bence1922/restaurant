import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { User } from 'src/app/generated-api/model/user';
import { LoginComponent } from '../login/login.component';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/generated-api/api/auth.service';


@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule, LoginComponent],
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent{
  showLoginPopup: boolean = false;
  isloggedIn: boolean = false;

  constructor(
    private router: Router,
    private authService: AuthService,
  ) {}

  ngOnInit(): void {
    this.isloggedIn = this.authService.isLoggedIn();
    this.hasOneOfTheRoles(['admin', 'user']);
  }

  hasOneOfTheRoles(roles: string[]): boolean{
    if(this.isloggedIn){
      for(let role of roles){
        if(this.authService.hasRole(role)){
          return true;
        }
      }
    }
    return false;
  }

  redirectToLogin(){
    this.router.navigate(['/login']);
  }
}
