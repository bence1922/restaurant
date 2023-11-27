import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DividerModule } from 'primeng/divider';
import { ButtonModule } from 'primeng/button';
import { Order } from 'src/app/generated-api/model/order';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { RatingModule } from 'primeng/rating';
import { PdfGeneratorService } from 'src/app/services/pdfGenerator.service';
import { CustomerOrderService } from 'src/app/generated-api/api/customerOrder.service';
import { StoreUserService } from 'src/app/generated-api/api/store.service';
import { CustomerOrder, } from 'src/app/generated-api';
import { Customer } from 'src/app/generated-api/model/customer';
import { CustomerService } from 'src/app/generated-api/api/api';


@Component({
  selector: 'app-orders-profile',
  standalone: true,
  imports: [CommonModule, DividerModule, ButtonModule, RatingModule, ReactiveFormsModule],
  templateUrl: './orders-profile.component.html',
  styleUrls: ['./orders-profile.component.scss'],
})
export class OrdersProfileComponent implements OnInit{
  orderList?: CustomerOrder[] | null
  formGroup!: FormGroup;
  pdfGenreator= new PdfGeneratorService()
  openInfoMap= new Map<string, boolean>()


  constructor(
    private customerOrderService: CustomerOrderService,
    private storeUsderService: StoreUserService,
    private customerService: CustomerService
  ) {}

  ngOnInit(): void {
    this.formGroup = new FormGroup({
        rating: new FormControl(5)
    });

    this.customerService.queryOrdersForCustomer(this.storeUsderService.getUserId(), true).subscribe((orders) => {
      this.orderList=orders
    })
  }

  price(order: Order){
    var price=0
    if(order.drinks!==undefined){
      order.drinks.forEach(item => {
        price += item.drink.price*item.quantity
      });
    }

    if(order.foods!==undefined){
      order.foods.forEach(item =>{
        price += item.food.price*item.quantity
      })
    }
    return price
  }

  addRating(order: CustomerOrder){
      console.log(this.formGroup.value.rating)
      this.customerService.updateCustomerOrder(order.id, this.storeUsderService.getUserId(), this.formGroup.value.rating).subscribe()
  }

  openInfo(order: CustomerOrder){
    if(this.openInfoMap.get(order.id)!=null){
      return true
    }
    else return false
  }

  openInfoBtnClicked(order: CustomerOrder){
    if(this.openInfoMap.get(order.id)!=null){
      this.openInfoMap.delete(order.id)
    }
    else{
      this.openInfoMap.set(order.id, true)
    }
  }

  generateInvoice(order: Order){
    this.pdfGenreator.generatePdf(order)
  }

  date(sD: string){
    var startingDate = new Date(sD)
    const year: number = startingDate.getFullYear(); // Get the year (e.g., 2023)
    const month: number = startingDate.getMonth() + 1; // Get the month (January is 0, so adding 1)
    const day: number = startingDate.getDate(); // Get the day of the month
    return `${year}.${month.toString().padStart(2, '0')}.${day.toString().padStart(2, '0')}`
  }

  time(sD: string){
    var startingDate= new Date(sD)

    const startHours: number = startingDate.getHours(); // Get the hours
    const startMinutes: number = startingDate.getMinutes(); // Get the minutes

    return `${startHours.toString().padStart(2, '0')}:${startMinutes.toString().padStart(2, '0')}`
  }

  fullDate(date: string){
    return this.date(date)+" - "+this.time(date)
  }
}
