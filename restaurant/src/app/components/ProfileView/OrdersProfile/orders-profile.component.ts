import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DividerModule } from 'primeng/divider';
import { ButtonModule } from 'primeng/button';
import { Order } from 'src/app/generated-api/model/order';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { RatingModule } from 'primeng/rating';


@Component({
  selector: 'app-orders-profile',
  standalone: true,
  imports: [CommonModule, DividerModule, ButtonModule, RatingModule, ReactiveFormsModule],
  templateUrl: './orders-profile.component.html',
  styleUrls: ['./orders-profile.component.scss'],
})
export class OrdersProfileComponent implements OnInit{
  orderList?: Order[] | null
  current?: Order | null
  openInfo: Boolean = false;
  formGroup!: FormGroup;

  ngOnInit(): void {
    this.formGroup = new FormGroup({
        rating: new FormControl(5)
    });

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
