import { Component, OnInit } from '@angular/core';
import { CommonModule, Time } from '@angular/common';
import { HeroComponent } from '../Hero/hero.component';
import { DividerModule } from 'primeng/divider';
import { CalendarModule } from 'primeng/calendar';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Booking, BookingService, NewBooking, Table } from 'src/app/generated-api';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { StoreUserService } from 'src/app/generated-api/api/store.service';

@Component({
  selector: 'app-reservation',
  standalone: true,
  imports: [CommonModule, HeroComponent, DividerModule, CalendarModule, FormsModule, ReactiveFormsModule],
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.scss'],
})
export class ReservationComponent implements OnInit {
  date: Date | undefined
  now = new Date();
  newReservationForm = new FormGroup({
    date: new FormControl("", [Validators.required]),
    time: new FormControl("10:00", [Validators.required, Validators.min(10), Validators.max(20)]),
    guests: new FormControl(0, [Validators.required]),
    note: new FormControl(''),
  })
  tableNum=-1
  errorMsg: String | undefined

  public startDate: Date = new Date();
  public hours: number = 1;
  public selectedTable: Table | undefined;
  public avaibleTables: Array<Table> = new Array<Table>();
  
  constructor(
    private bookingService: BookingService,
    private router: Router,
    private storeUserService: StoreUserService
  ) {}

  // book(start: Date, end: Date){
  //   var data: NewBooking={
  //     tableNumber: this.tableNum,
  //     user_id: localStorage.getItem('userId')! ,
  //     startingDate: start,
  //     endingDate: end,
  //     peopleCount: this.newReservationForm.value.guests!
  //   }

  //   this.bookingService.bookTable(data).subscribe(
  //     (result) => {
  //       alert("Success!")
  //       this.router.navigate(['/profile/reservations'])
  //     },
  //     (error : HttpErrorResponse) =>{
  //       alert(error.error)
  //     }
  //   )
  // }

  public findAvaibleTables() {
    const from = new Date(this.startDate);
    const to = new Date(from);
    to.setHours(from.getHours()+this.hours);
    console.log(this.selectedTable);
    this.bookingService.queryTablesForBooking(from.toISOString(), to.toISOString()).subscribe(
      (result) => {
        console.log(result);
        this.avaibleTables = result;
      },
      (error) => {
        console.error(error);
      }
    );
  }

  // onSubmit(){
  //   var tables= new Array<Table>

  //   var startingDate= this.createStartingDate(new Date(this.newReservationForm.value.date!), this.newReservationForm.value.time!)
  //   var endDate = this.createEndDate(new Date(this.newReservationForm.value.date!), this.newReservationForm.value.time!)
    
  //   this.bookingService.queryTablesForBooking(startingDate, endDate).subscribe(
  //     (result)=> tables=result
  //   )

  //   if(tables == null){
  //     this.errorMsg="Nincs szabad asztal"
  //   }else if(this.tableAvailable(tables)){
  //     this.errorMsg=undefined
  //     this.book(startingDate, endDate)
  //   }
  //   else{
  //     this.errorMsg = "Nincs ennyi főre szabad asztal"
  //   }
  // }
  createStartingDate(date: Date, timeStr: String){
    let startingDate = new Date(date)
    var timeStringArray = timeStr.split(':')
    var time= new Date();
    time.setHours(+timeStringArray[0]);
    time.setMinutes(+timeStringArray[1]);
    startingDate.setHours(time.getHours())
    startingDate.setMinutes(time.getMinutes())
    return startingDate;
  }

  createEndDate(date: Date, time: String){
    var endDate = this.createStartingDate(date, time);
    endDate.setHours(endDate.getHours()+2)
    return endDate
  }

  createStartDateStr(){
    var timeStringArray = this.newReservationForm.value.time!.split(':')
    var time= new Date();
    time.setHours(+timeStringArray[0]);
    time.setMinutes(+timeStringArray[1]);
    return time.getHours+":"+time.getMinutes
  }
  createStartMinuteStringArray(){
    var timeStringArray = this.newReservationForm.value.time!.split(':')
    var time=new Date();
    time.setHours(+timeStringArray[0]);
    time.setMinutes(+timeStringArray[1]);
    return time.getHours+":"+time.getMinutes
  }
  createEndDateStr(time: Date){
    var endDate= new Date();
    endDate.setHours(time.getHours()+2);
    endDate.setMinutes(time.getMinutes())
    return endDate.getHours+":"+endDate.getMinutes()
  }

  tableAvailable(table: Array<Table>){
    table.forEach(item=>{
      if(item.capacity>=this.newReservationForm.value.guests!)
      this.tableNum=item.number
      return true
    })
    return false
  }
  ngOnInit(){
  }

  getNextHour(): string {
    const now = new Date();
    now.setHours(now.getHours() + 1);
    now.setMinutes(0);
    now.setSeconds(0);
    return now.toISOString().slice(0, 16);
  }
}
