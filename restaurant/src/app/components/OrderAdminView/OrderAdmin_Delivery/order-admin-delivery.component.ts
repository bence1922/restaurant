import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TableModule } from 'primeng/table';
import { Order } from 'src/app/generated-api/model/models';
import { ButtonModule } from 'primeng/button';
import { MenuItem } from 'primeng/api';
import { RatingModule } from 'primeng/rating';
import { DropdownModule } from 'primeng/dropdown';
import { PdfGeneratorService } from 'src/app/services/pdfGenerator.service';

@Component({
  selector: 'app-order-admin-delivery',
  standalone: true,
  imports: [CommonModule, TableModule, ButtonModule,  RatingModule, DropdownModule ],
  templateUrl: './order-admin-delivery.component.html',
  styleUrls: ['./order-admin-delivery.component.scss'],
})
export class OrderAdminDeliveryComponent implements OnInit {
  orders!: Order[] 
  statusData!: MenuItem[]
  pdfGenerator= new PdfGeneratorService()

  ngOnInit(): void {
    this.statusData=[
      {label: Order.StatusEnum.Placed,},
      {label: Order.StatusEnum.Cooking,},
      {label: Order.StatusEnum.Delivering,},
      {label: Order.StatusEnum.Delivered,},
    ]
    this.orders= new Array<Order>()
  }

  deleteOrder(order: Order){}

  calculatePrice(order: Order){

  }

  generateInvoice(order: Order){
    this.pdfGenerator.generatePdf(order)
  }
}
