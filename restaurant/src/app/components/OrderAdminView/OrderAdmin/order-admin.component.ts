import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuItem } from 'primeng/api';
import { TabMenuModule } from 'primeng/tabmenu';
import { HeroComponent } from '../../Hero/hero.component';

@Component({
  selector: 'app-order-admin',
  standalone: true,
  imports: [CommonModule, TabMenuModule, HeroComponent],
  templateUrl: './order-admin.component.html',
  styleUrls: ['./order-admin.component.scss'],
})
export class OrderAdminComponent implements OnInit {
  tabmenuItems: MenuItem[] | undefined

  ngOnInit(): void {
    this.tabmenuItems = [
      {label: 'In Place', routerLink: "orderadmin/inplace" },
      {label: 'Delivery', routerLink: "orderadmin/delivery"},
    ]
  }
}
