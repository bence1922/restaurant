import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ButtonModule } from 'primeng/button';
import { DropdownModule } from 'primeng/dropdown';
import { RatingModule } from 'primeng/rating';
import { TableModule } from 'primeng/table';
import { MenuItem } from 'primeng/api';
import { Drink, Food, Order } from 'src/app/generated-api';
import { FormsModule } from '@angular/forms';
import { DialogModule } from 'primeng/dialog';
import { SplitButtonModule } from 'primeng/splitbutton';


@Component({
  selector: 'app-order-admin-in-place',
  standalone: true,
  imports: [CommonModule, TableModule, ButtonModule,  RatingModule, DropdownModule, FormsModule, SplitButtonModule, DialogModule ],
  templateUrl: './order-admin-in-place.component.html',
  styleUrls: ['./order-admin-in-place.component.scss'],
})
export class OrderAdminInPlaceComponent  implements OnInit{
  orders!: Order[] 
  statusData!: MenuItem[]
  foodList!: Food[]
  drinkList!: Drink[]
  selectedFood: Food | undefined
  selectedDrink: Drink | undefined
  dialogVisible: boolean=false
  closingOrder: Order | undefined
  
  ngOnInit(): void {
    this.statusData=[
      {label: Order.StatusEnum.Placed,},
      {label: Order.StatusEnum.Cooking,},
      {label: Order.StatusEnum.Delivering,},
      {label: Order.StatusEnum.Delivered,},
    ]

    let order: Order = {
      id: "0",
      status: Order.StatusEnum.Placed,
      date: new Date(),
      note: "Note",
      foods: [
        {
          food: {
            id: "0",
            name: "Food",
            type: "Food",
            price: 2000,
          },
          quantity: 1
        }
      ],
      drinks: [
        {
          drink: {
            id: "0",
            name: "Drink",
            type: "Drink",
            price: 1000,
          },
          quantity: 1
        },
      ]
    }
    this.orders= new Array<Order>()
    this.orders.push(order)

    this.foodList=[
      {
        id: "0",
        name: "Food",
        type: "Food",
        price: 2000,
      },
      {
        id: "0",
        name: "Food",
        type: "Food",
        price: 2000,
      },
      {
        id: "0",
        name: "Food",
        type: "Food",
        price: 2000,
      }
    ]

    this.drinkList=[
      {
        id: "0",
        name: "Drink",
        type: "Drink",
        price: 1000,
      },
      {
        id: "0",
        name: "Drink",
        type: "Drink",
        price: 1000,
      },
    ]
  }

  calculatePrice(order: Order){
    if(order!==undefined){
      let price =0;
      order.foods.forEach(item => {
        price+= item.food.price*item.quantity
      });

      order.drinks.forEach(item => {
        price+= item.drink.price*item.quantity
      });

      return price
    }
    return 0
  }
  calculatePoints(order: Order) : number{
    if(order!==undefined){
    return this.calculatePrice(order)/100
    }
    return 0
  }

  deleteOrder(order: Order){

  }

  paid(order: Order){
    this.dialogVisible=true
    this.closingOrder=order
  }

  increase(food: boolean, order: Order, index: number){
    if(food){
      order.foods[index].quantity++
    }else{
      order.drinks[index].quantity++
    }
  }

  decrease(food: boolean, order: Order, index: number){
    if(food){
      order.foods[index].quantity--
      if(order.foods[index].quantity==0) order.foods.splice(index, 1)
    }else{
      order.drinks[index].quantity--
      if(order.drinks[index].quantity==0) order.drinks.splice(index, 1)
    }
  }

  addOrderItem(food: boolean, order: Order){
    if(food){
    order.foods.push({
      food: this.selectedFood!,
      quantity: 1
    })
    this.selectedFood=undefined
    }
    else{
      order.drinks.push({
        drink: this.selectedDrink!,
        quantity: 1
      })
      this.selectedDrink=undefined
    }
  }

  closeOrder(){
    this.dialogVisible=false
  }
  newOrder(){
    // TODO: hozzáad egy új ordert + adatbázisba kerül (table-t kell megadni, többi default)
  }
}
