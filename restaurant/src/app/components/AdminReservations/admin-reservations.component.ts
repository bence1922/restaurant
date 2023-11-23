import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DividerModule } from 'primeng/divider';
import { Booking, BookingService } from 'src/app/generated-api';
import { ButtonModule } from 'primeng/button';

@Component({
  selector: 'app-admin-reservations',
  standalone: true,
  imports: [CommonModule, DividerModule, ButtonModule],
  templateUrl: './admin-reservations.component.html',
  styleUrls: ['./admin-reservations.component.scss'],
})
export class AdminReservationsComponent {
  incomingReservations: Booking[] | null = null;
  todayReservations: Booking[] | null = null;
  upcomingReservations: Booking[] | null = null;
  oldReservations: Booking[] | null = null;

  constructor(
    private bookingService: BookingService,
  ) {}


  ngOnInit(): void {
    this.bookingService.getBookings().subscribe((bookings: Booking[]) => {
      this.incomingReservations = bookings.filter((booking: Booking) => {
        return booking.status === "pending";
      });
      this.todayReservations = bookings.filter((booking: Booking) => {
        var today = new Date();
        today.setHours(0,0,0,0);
        return this.stringToDate(booking.startingDate).toDateString === today.toDateString;
      });
      this.upcomingReservations = bookings.filter((booking: Booking) => {
        var today = new Date();
        today.setHours(0,0,0,0);
        return this.stringToDate(booking.startingDate).toDateString > today.toDateString;
      });
      this.oldReservations = bookings.filter((booking: Booking) => {
        var today = new Date();
        today.setHours(0,0,0,0);
        return this.stringToDate(booking.startingDate).toDateString < today.toDateString;
      });
    });

    var booking: Booking
    booking={
      table:{
        number:0,
        capacity:4
      },
      customer:{
        userId: "0",
        name: "Name name"
      },
      startingDate: "1234",
      endingDate: "1234"
    },
    this.incomingReservations = new Array()
    for(let i = 0; i < 3; i++){
      this.incomingReservations.push(booking)
    }

    this.todayReservations = new Array()
    for(let i = 0; i < 3; i++){
      this.todayReservations.push(booking)
    }

    this.upcomingReservations = new Array()
    for(let i = 0; i < 3; i++){
      this.upcomingReservations.push(booking)
    }

    this.oldReservations = new Array()
    for(let i = 0; i < 3; i++){
      this.oldReservations.push(booking)
    }
  }

  stringToDate(dateString: string){
    const dateParts = dateString.split(/[\s.]+/);

    const year = +dateParts[0]; // Convert to number
    const day = +dateParts[1]; // Convert to number
    const month = +dateParts[2]; // Convert to number
    const [hours, minutes] = dateParts[3].split(':').map(part => +part); // Extract hours and minutes

    return new Date(year, month - 1, day, hours, minutes);
  }

  getDateDays(dateString: string){
    const date = this.stringToDate(dateString);

    const year: number = date.getFullYear(); // Get the year (e.g., 2023)  
    const month: number = date.getMonth() + 1; // Get the month (January is 0, so adding 1)
    const day: number = date.getDate(); // Get the day of the month

    return `${year}-${month.toString().padStart(2, '0')}-${day.toString().padStart(2, '0')}`;
  }

  getDateHours(dateString: string){
    const date = this.stringToDate(dateString);

    const hours: number = date.getHours(); // Get the hours
    const minutes: number = date.getMinutes(); // Get the minutes

    return `${hours.toString()}:${minutes.toString()}`;
  }

  onAcceptClick(booking: Booking){}

  onDeclineClick(booking: Booking){}


  date(startingDate: string){
    return "2023.10.10."
  }

  time(startingDate: string, endingDate: string){
    return "18:00 - 20:00"
  }

}