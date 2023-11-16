import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DividerModule } from 'primeng/divider';
import { Booking } from 'src/app/data/booking';

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

  ngOnInit(): void {
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
      this.currentReservations = new Array()
      for(let i = 0; i < 3; i++){
        this.currentReservations.push(booking)
      }

      this.previousReservations = new Array()
      for(let i = 0; i < 3; i++){
        this.previousReservations.push(booking)
      }
  }

  date(startingDate: string){
    return "2023.10.10."
  }

  time(startingDate: string, endingDate: string){
    return "18:00 - 20:00"
  }
}
