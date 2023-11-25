import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeroComponent } from '../Hero/hero.component';
import { DividerModule } from 'primeng/divider';
import { ButtonModule } from 'primeng/button';
import { Order, User } from 'src/app/generated-api';
import { RatingModule } from 'primeng/rating';

@Component({
  selector: 'app-order',
  standalone: true,
  imports: [CommonModule, HeroComponent, DividerModule, ButtonModule, RatingModule],
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss'],
})
export class OrderComponent implements OnInit {
  user!: User; 
  order!: Order; 
  orderplaced: boolean=false
 

  ngOnInit(): void {
  }

  placeOrder(){
    //TODO
    this.orderplaced=true
  }

  total(){
    var price = 0
    this.order?.foods.forEach(item => {
      price+= item.food.price*item.quantity
    });

    this.order?.drinks.forEach(item => {
      price+= item.drink.price*item.quantity
    });

    return price
  }

  increase(food: boolean, index: number){
    if(food){
      this.order.foods[index].quantity++
    }else{
      this.order.drinks[index].quantity++
    }
  }

  decrease(food: boolean, index: number){
    if(food){
      this.order.foods[index].quantity--
      if(this.order.foods[index].quantity==0) this.order.foods.splice(index, 1)
    }else{
      this.order.drinks[index].quantity--
      if(this.order.drinks[index].quantity==0) this.order.drinks.splice(index, 1)
    }
  }
}
