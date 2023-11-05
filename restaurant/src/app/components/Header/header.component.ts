import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TabMenuModule } from 'primeng/tabmenu';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule, TabMenuModule],
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {
  items: MenuItem[] = [];

  ngOnInit(){
    this.items=[
      {label: 'Home', icon: 'pi pi-fw pi-home', routerLink: ['/home']},
      {label: 'About us', routerLink: ['/about-us']},
      {label: 'Menu', routerLink: ['/menu']},
      {label: 'Reservation', routerLink: ['/reservation']},
      {label: 'Order', routerLink: ['/menu']},
      //{icon: 'pi pi-fw pi-users', routerLink: ['/profile']}
    ]
  }
}
