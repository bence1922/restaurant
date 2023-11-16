import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { User } from 'src/app/generated-api/model/user';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent {
  user: User | undefined;

  constructor() {
    if(!this.user || this.user?.role=="customer"){
      console.log("customer");
    }
    if(this.user?.role=="manager" || this.user?.role=="waiter"){
      console.log("employee");
    }
  }

}
