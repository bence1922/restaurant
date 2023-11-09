import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeroComponent } from '../Hero/hero.component';
import { ImageModule } from 'primeng/image';

@Component({
  selector: 'app-about-us',
  standalone: true,
  imports: [CommonModule, HeroComponent, ImageModule],
  templateUrl: './about-us.component.html',
  styleUrls: ['./about-us.component.scss'],
})
export class AboutUsComponent {}
