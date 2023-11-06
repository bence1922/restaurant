import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeroComponent } from '../Hero/hero.component';
import { DividerModule } from 'primeng/divider';
import { CalendarModule } from 'primeng/calendar';

@Component({
  selector: 'app-reservation',
  standalone: true,
  imports: [CommonModule, HeroComponent, DividerModule, CalendarModule],
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.scss'],
})
export class ReservationComponent {
  date: Date | undefined
}
