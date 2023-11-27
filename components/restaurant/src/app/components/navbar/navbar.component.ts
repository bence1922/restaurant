import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from '../login/login.component';
import { Router } from '@angular/router';
import { StoreUserService } from 'src/app/generated-api/api/store.service';
import { ButtonModule } from 'primeng/button';
import { AuthService } from 'src/app/generated-api';


@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule, LoginComponent, ButtonModule],
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent{
  showLoginPopup: boolean = false;
  isloggedIn: boolean = false;

  constructor(
    private router: Router,
    private storeUserService: StoreUserService,
    private authService: AuthService,
  ) {}

  ngOnInit(): void {
    this.isloggedIn = this.storeUserService.isLoggedIn();
  }

  hasOneOfTheRoles(roles: string[]): boolean{
    if(this.isloggedIn){
      for(let role of roles){
        if(this.storeUserService.hasRole(role)){
          return true;
        }
      }
    }
    return false;
  }

  logInOut(){
    if(this.isloggedIn){
      this.authService.logout();
      this.storeUserService.logout();
      this.router.navigate(['/']);
    };
    this.router.navigate(['/login']);
  }
}
