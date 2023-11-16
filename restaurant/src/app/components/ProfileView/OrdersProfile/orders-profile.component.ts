import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DividerModule } from 'primeng/divider';
import { ButtonModule } from 'primeng/button';

@Component({
  selector: 'app-orders-profile',
  standalone: true,
  imports: [CommonModule, DividerModule, ButtonModule],
  templateUrl: './orders-profile.component.html',
  styleUrls: ['./orders-profile.component.scss'],
})
export class OrdersProfileComponent implements OnInit{
  orderList: any[] | undefined

  ngOnInit(): void {
      this.orderList = new Array<any>
  }
}
