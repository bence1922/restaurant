import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ButtonModule } from 'primeng/button';
import { DropdownModule } from 'primeng/dropdown';
import { RatingModule } from 'primeng/rating';
import { TableModule } from 'primeng/table';
import { MenuItem } from 'primeng/api';
import { Drink, DrinkOrderItem, Food, FoodOrderItem, Order, Table, TableOrder, TableService } from 'src/app/generated-api';
import { FormsModule } from '@angular/forms';
import { DialogModule } from 'primeng/dialog';
import { SplitButtonModule } from 'primeng/splitbutton';
import { TableOrderService } from 'src/app/generated-api/api/tableOrder.service';
import { table } from 'console';


@Component({
  selector: 'app-order-admin-in-place',
  standalone: true,
  imports: [CommonModule, TableModule, ButtonModule,  RatingModule, DropdownModule, FormsModule, SplitButtonModule, DialogModule ],
  templateUrl: './order-admin-in-place.component.html',
  styleUrls: ['./order-admin-in-place.component.scss'],
})
export class OrderAdminInPlaceComponent  implements OnInit{
  orders!: TableOrder[] 
  statusData!: MenuItem[]
  foodList!: Food[]
  drinkList!: Drink[]
  selectedFood: Food | undefined
  selectedDrink: Drink | undefined
  dialogVisible: boolean=false
  
  quantity=[1,2,3,4,5,6,7,8,9]
  selectedTable!: Table
  //orderId!: string
  freeTables: Table[] = new Array<Table>()
  newOrder!: Order
  selectFood!: Food | undefined
  selectDrink!: Drink | undefined
  selectFoodQuantity!: number
  selectDrinkQuantity!: number

  constructor(
    private tableOrderService: TableOrderService,
    private tableService: TableService,
  ){}

  ngOnInit(): void {
    this.statusData=[
      {label: Order.StatusEnum.Placed,},
      {label: Order.StatusEnum.Cooking,},
      {label: Order.StatusEnum.Delivering,},
      {label: Order.StatusEnum.Delivered,},
    ]
    this.orders= new Array<TableOrder>()
    const currentTables = new Array<Table>()
    const allTables = new Array<Table>()
    this.tableService.queryTableOrders(undefined, true).subscribe((tables) => {
      tables.forEach(table => {
        currentTables.push(table.table)
      })
    })
    this.tableService.queryTableOrders().subscribe((tables) => {
      this.orders = tables
      tables.forEach(table => {
        allTables.push(table.table)
      })
    })
    this.freeTables = allTables.filter(table => !currentTables.includes(table))
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

  paid(order: TableOrder){
    this.tableService.updateTableOrder(order.id, undefined, "delivered").subscribe()
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

  addToOrder(){
    const aaafood = {
      food: this.selectFood,
      quantity: this.selectFoodQuantity
    } as FoodOrderItem

    const aaadrink = {
      drink: this.selectDrink,
      quantity: this.selectDrinkQuantity
    } as DrinkOrderItem

    this.newOrder.foods.push(aaafood)
    this.newOrder.drinks.push(aaadrink)
    this.selectFood=undefined
    this.selectDrink=undefined
    this.selectFoodQuantity=0
    this.selectDrinkQuantity=0
  }


  closeOrder(){
    this.tableOrderService.placeOrder(this.selectedTable.number!, this.newOrder).subscribe()
    this.newOrder=undefined!
    this.dialogVisible=false
  }

  newOrderFunc(){
    this.newOrder={
      foods: new Array<FoodOrderItem>(),
      drinks: new Array<DrinkOrderItem>(),
    } as Order
    this.dialogVisible=true
    // TODO: hozzáad egy új ordert + adatbázisba kerül (table-t kell megadni, többi default)
  }
}
