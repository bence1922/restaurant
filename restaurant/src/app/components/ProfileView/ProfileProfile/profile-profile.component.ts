import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ButtonModule } from 'primeng/button';

@Component({
  selector: 'app-profile-profile',
  standalone: true,
  imports: [CommonModule, ButtonModule],
  templateUrl: './profile-profile.component.html',
  styleUrls: ['./profile-profile.component.scss'],
})
export class ProfileProfileComponent {}
