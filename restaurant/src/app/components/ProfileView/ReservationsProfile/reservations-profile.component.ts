import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DividerModule } from 'primeng/divider';
import { Booking } from 'src/app/generated-api/model/booking';


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
  }

  date(startingDate: string){
    return "2023.10.10."
  }

  time(startingDate: string, endingDate: string){
    return "18:00 - 20:00"
  }
}
