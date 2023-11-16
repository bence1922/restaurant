import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DividerModule } from 'primeng/divider';
import { ButtonModule } from 'primeng/button';
import { Order } from 'src/app/data/order';

@Component({
  selector: 'app-orders-profile',
  standalone: true,
  imports: [CommonModule, DividerModule, ButtonModule],
  templateUrl: './orders-profile.component.html',
  styleUrls: ['./orders-profile.component.scss'],
})
export class OrdersProfileComponent implements OnInit{
  orderList?: Order[] | null
  current?: Order | null
  openInfo: Boolean = false;

  ngOnInit(): void {
    var item : Order
    item = {
      status: Order.StatusEnum.Delivered,
      foods: [],
      drinks: []
    }
    this.current=item

    this.orderList = new Array<Order>
    for(let i = 0; i < 3; i++){
      this.orderList.push(item)
    }
  }

  price(order: Order){
    var price=0
    order.drinks.forEach(item => {
      price += item.drink.price*item.quantity
    });

    order.foods.forEach(item =>{
      price += item.food.price*item.quantity
    })

    return price
  }
}
