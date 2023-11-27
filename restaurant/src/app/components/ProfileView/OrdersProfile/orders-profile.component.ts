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
import { CustomerOrder, CustomerService } from 'src/app/generated-api';


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
  pdfGenreator= new PdfGeneratorService()

  constructor(
    private customerOrderService: CustomerOrderService,
    private storeUsderService: StoreUserService,
    private customerService: CustomerService
  ) {}

  ngOnInit(): void {
    this.formGroup = new FormGroup({
        rating: new FormControl(5)
    });

    this.current
    this.customerOrderService.queryCustomerOrderForCustomer(this.storeUsderService.getUser().id!, true).subscribe((orders) => {
      this.current = orders[0]
    })
    this.customerOrderService.queryCustomerOrderForCustomer(this.storeUsderService.getUser().id!, false).subscribe((orders) => {
      this.orderList = orders
    })
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

  addRating(){
    if(this.current){
      this.formGroup.value.rating
      this.customerService.queryCustomerOrders(this.storeUsderService.getUserName(), true).subscribe((customerOrder: CustomerOrder[]) => {
        const currentOrder = customerOrder[0]
        this.customerService.updateCustomerOrder(currentOrder.id, this.storeUsderService.getUserId(), this.formGroup.value.rating).subscribe((order) => {
          this.current = order
        })
      })
    }
  }

  generateInvoice(order: Order){
    this.pdfGenreator.generatePdf(order)
  }
}
