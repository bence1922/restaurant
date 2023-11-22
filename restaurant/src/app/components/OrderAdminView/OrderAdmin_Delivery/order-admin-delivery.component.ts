import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TableModule } from 'primeng/table';
import { Order } from 'src/app/generated-api/model/models';
import { ButtonModule } from 'primeng/button';
import { TooltipModule } from 'primeng/tooltip';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MenuItem } from 'primeng/api';
import { RatingModule } from 'primeng/rating';
import { DropdownModule } from 'primeng/dropdown';

@Component({
  selector: 'app-order-admin-delivery',
  standalone: true,
  imports: [CommonModule, TableModule, ButtonModule, TooltipModule,  SplitButtonModule,RatingModule, DropdownModule ],
  templateUrl: './order-admin-delivery.component.html',
  styleUrls: ['./order-admin-delivery.component.scss'],
})
export class OrderAdminDeliveryComponent implements OnInit {
  orders!: Order[] 
  splitbuttonData!: MenuItem[]

  ngOnInit(): void {
    this.splitbuttonData=[
      {label: Order.StatusEnum.Placed,},
      {label: Order.StatusEnum.Cooking,},
      {label: Order.StatusEnum.Delivering,},
      {label: Order.StatusEnum.Delivered,},
    ]

    let order: Order = {
      foods: [
        {
          food: {
            name: "Food",
            price: 2000,
          },
          quantity: 1
        }
      ],
      drinks: [
        {
          drink: {
            name: "Drink",
            price: 1000,
          },
          quantity: 1
        },
      ]
    }
    this.orders= new Array<Order>()
    this.orders.push(order)
  }

  deleteOrder(order: Order){}

  export(order: Order){}

  calculatePrice(order: Order){

  }
}
