import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TabMenuModule } from 'primeng/tabmenu';
import { MenuItem } from 'primeng/api';
import { ProfileProfileComponent } from '../ProfileProfile/profile-profile.component';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [CommonModule, TabMenuModule, ProfileProfileComponent],
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss'],
})
export class ProfileComponent implements OnInit  {
  tabmenuItems: MenuItem[] | undefined

  ngOnInit(){
    this.tabmenuItems = [
      {label: 'Profile', routerLink: "datas" },
      {label: 'Reservations', routerLink: "reservations"},
      {label: 'Orders', routerLink: "orders"},
    ]
  }
}
