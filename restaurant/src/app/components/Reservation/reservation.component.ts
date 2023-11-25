import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeroComponent } from '../Hero/hero.component';
import { DividerModule } from 'primeng/divider';
import { CalendarModule } from 'primeng/calendar';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { BookingService, NewBooking } from 'src/app/generated-api';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reservation',
  standalone: true,
  imports: [CommonModule, HeroComponent, DividerModule, CalendarModule, FormsModule, ReactiveFormsModule],
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.scss'],
})
export class ReservationComponent implements OnInit {
  date: Date | undefined
  newReservationForm = new FormGroup({
    name: new FormControl('', [Validators.required]),
    date: new FormControl('', [Validators.required]),
    time: new FormControl('', [Validators.required]),
    guests: new FormControl(0, [Validators.required]),
    email: new FormControl('', [Validators.required]),
    phone: new FormControl('', [Validators.required]),
    note: new FormControl(''),
  })
  
  constructor(
    private bookingService: BookingService,
    private router: Router
  ) {}

  onSubmit(){
    var customerId = '1'  
    var data: NewBooking={
      tableNumber: 1, //TODO
      user_id: customerId,
      startingDate: new Date(this.newReservationForm.value.date!).toString(),
      endingDate: "",
      peopleCount: this.newReservationForm.value.guests!
    }

    // this.bookingService.bookTable(data).subscribe(
    //   (result) => {
    //     alert("Success!")
    //     this.router.navigate(['/profile/reservations'])
    //   },
    //   (error : HttpErrorResponse) =>{
    //     console.log(error)
    //     alert(error.statusText)
    //   }
    // )

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
    var time= new Date();
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

  ngOnInit(){
  }
}
