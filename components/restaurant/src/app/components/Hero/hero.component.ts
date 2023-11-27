import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ImageModule } from 'primeng/image';

@Component({
  selector: 'app-hero',
  standalone: true,
  imports: [CommonModule, ImageModule],
  templateUrl: './hero.component.html',
  styleUrls: ['./hero.component.scss'],
})
export class HeroComponent {
  @Input() label: string = "Label";
}
