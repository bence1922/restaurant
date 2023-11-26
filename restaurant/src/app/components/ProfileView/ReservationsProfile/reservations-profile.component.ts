import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DividerModule } from 'primeng/divider';
import { Booking } from 'src/app/generated-api/model/booking';
import { StoreUserService } from 'src/app/generated-api/api/store.service';
import { BookingService, UserService } from 'src/app/generated-api';


@Component({
  selector: 'app-reservations-profile',
  standalone: true,
  imports: [CommonModule, DividerModule],
  templateUrl: './reservations-profile.component.html',
  styleUrls: ['./reservations-profile.component.scss'],
})
export class ReservationsProfileComponent implements OnInit {
  currentReservations?: Booking[] | null
  previousReservations?: Booking[] | null

  constructor(
    private storeUsderService: StoreUserService,
    private userService: UserService,
    private bookingService: BookingService,
  ) { }

  ngOnInit(): void {
    this.bookingService.queryBookings(undefined, this.storeUsderService.getUser().name!).subscribe((bookings) => {

    })
  }

  date(startingDate: Date){
    const year: number = startingDate.getFullYear(); // Get the year (e.g., 2023)
    const month: number = startingDate.getMonth() + 1; // Get the month (January is 0, so adding 1)
    const day: number = startingDate.getDate(); // Get the day of the month
    return `${year}.${month.toString().padStart(2, '0')}.${day.toString().padStart(2, '0')}`
  }

  time(startingDate: Date, endingDate: Date){
    const startHours: number = startingDate.getHours(); // Get the hours
    const startMinutes: number = startingDate.getMinutes(); // Get the minutes

    const endHours: number = endingDate.getHours(); // Get the hours
    const endMinutes: number = endingDate.getMinutes(); // Get the minutes
    return `${startHours.toString().padStart(2, '0')}:${startMinutes.toString().padStart(2, '0')} - ${endHours.toString().padStart(2, '0')}:${endMinutes.toString().padStart(2, '0')}`
  }
}
