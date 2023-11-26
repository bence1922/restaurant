import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeroComponent } from '../Hero/hero.component';
import { ImageModule } from 'primeng/image';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { SplitterModule } from 'primeng/splitter';
import { GalleriaModule } from 'primeng/galleria';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, HeroComponent, ImageModule, CardModule, ButtonModule, SplitterModule, GalleriaModule],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent {
  // Image gallery: https://primeng.org/galleria

  images: any[] | undefined;
  responsiveOptions: any[] | undefined;
  constructor(
    private router: Router,
  ) {}

  ngOnInit(){
    this.responsiveOptions = [
      {
          breakpoint: '1024px',
          numVisible: 5,
      },
      {
          breakpoint: '768px',
          numVisible: 3,
      },
      {
          breakpoint: '560px',
          numVisible: 1,
      }
  ];
  }

  goToMenu() {
    this.router.navigate(['/menu']);
  }

}
