import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeroComponent } from '../Hero/hero.component';
import { DividerModule } from 'primeng/divider';
import { ButtonModule } from 'primeng/button';
import { CustomerService, Order, User, UserService } from 'src/app/generated-api';
import { RatingModule } from 'primeng/rating';
import { CartService } from 'src/app/services/cart.service';
import { FormsModule } from '@angular/forms';
import { resume } from 'pdfkit';

@Component({
  selector: 'app-order',
  standalone: true,
  imports: [CommonModule, HeroComponent,FormsModule, DividerModule, ButtonModule, RatingModule],
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss'],
})
export class OrderComponent implements OnInit {
  user!: User; 
  order!: Order; 
  orderplaced: boolean=false
  id= localStorage.getItem('userId')!

 
  constructor(private cartService: CartService, private userService: UserService, private customerService: CustomerService){}

  ngOnInit(): void {
    

    // this.userService.getUserById(id).subscribe(
    //   (response)=>{
    //     this.user=response
    //   }
    // )
    this.order={
      foods: this.cartService.getFoods(),
      drinks: this.cartService.getDrinks(),
    }
  }

  placeOrder(){
    this.order.date=new Date().toISOString()
    this.order.status=Order.StatusEnum.Placed
    console.log(this.order)

    this.customerService.placeCustomerOrder(this.id).subscribe(
      (result)=>{
        this.orderplaced=true
      }
    )
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
    this.order.foods = this.cartService.getFoods()
  }

  decrease(food: boolean, index: number){
    this.cartService.decrease(food, index)
  }

  calculatePoints(){
    return this.total()/100
  }
}
