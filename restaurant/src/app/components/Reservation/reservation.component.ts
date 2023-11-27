import { Component, OnInit } from '@angular/core';
import { CommonModule, Time } from '@angular/common';
import { HeroComponent } from '../Hero/hero.component';
import { DividerModule } from 'primeng/divider';
import { CalendarModule } from 'primeng/calendar';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { BookingService, NewBooking, Table } from 'src/app/generated-api';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { StoreUserService } from 'src/app/generated-api/api/store.service';
import { networkInterfaces } from 'os';
import { Dropdown, DropdownModule } from 'primeng/dropdown';

@Component({
  selector: 'app-reservation',
  standalone: true,
  imports: [CommonModule, HeroComponent, DividerModule, CalendarModule, FormsModule, ReactiveFormsModule, DropdownModule],
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.scss'],
})
export class ReservationComponent implements OnInit {
  date: Date | undefined
  now = new Date();
  newReservationForm = new FormGroup({
    date: new FormControl(""),
    time: new FormControl("10:00",),
    guests: new FormControl(0, [Validators.required]),
    note: new FormControl(''),
  })
  tableNum=-1
  errorMsg: String | undefined
  guests= 1
  note=""

  public startDate: Date = new Date();
  public hours: number = 1;
  public selectedTable: Table | undefined;
  public avaibleTables: Array<Table> = new Array<Table>();
  
  constructor(
    private bookingService: BookingService,
    private router: Router,
    private storeUserService: StoreUserService
  ) {}

  public findAvaibleTables() {
    const from = new Date(this.startDate);
    const to = new Date(from);
    to.setHours(from.getHours()+this.hours);
    this.bookingService.queryTablesForBooking(from.toISOString(), to.toISOString()).subscribe(
      (result) => {
        this.avaibleTables = result;
        this.selectedTable=this.avaibleTables[0]
        
      },
      (error) => {
      }
    );
  }

  book(){
    const from = new Date(this.startDate);
    const to = new Date(from);
    to.setHours(from.getHours()+this.hours);

    var newBooking: NewBooking={
      tableNumber: this.selectedTable!.number,
      user_id: this.storeUserService.getUserId(),
      startingDate: from.toISOString(),
      endingDate: to.toISOString(),
      peopleCount: this.guests,
      note: this.note 
    }

    console.log(newBooking)


    this.bookingService.bookTable(newBooking ).subscribe(
      (result)=>{
        alert("Success!")
      }
    )
    
  }


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
