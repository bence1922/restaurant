import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeroComponent } from '../Hero/hero.component';
import { DividerModule } from 'primeng/divider';
import { ButtonModule } from 'primeng/button';
import { Order, User } from 'src/app/generated-api';
import { RatingModule } from 'primeng/rating';
import { CartService } from 'src/app/services/cart.service';

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

 
  constructor(private cartService: CartService){}

  ngOnInit(): void {
    console.log(this.cartService.getFoods())

    this.order={
      foods: this.cartService.getFoods(),
      drinks: this.cartService.getDrinks(),
    }
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
    this.cartService.increase(food, index)
  }

  decrease(food: boolean, index: number){
    this.cartService.decrease(food, index)
  }
}
