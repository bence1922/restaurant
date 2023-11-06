import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeroComponent } from '../Hero/hero.component';
import { Food } from 'src/app/data/Food';
import { DividerModule } from 'primeng/divider';
import { ButtonModule } from 'primeng/button';

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [CommonModule, HeroComponent, DividerModule, ButtonModule],
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss'],
})
export class MenuComponent implements OnInit {
  foodList: Food[ ] | undefined
  foodLabelList= ["Soup", "Dish", "Drink"]


  ngOnInit(): void{
    this.foodList= new Array<Food>
    for(let i = 0; i < 3; i++){
      this.foodList.push({
        label: `Dish `+i,
        description: "Small kitty warm kitty little balls of fur love blinks and purr purr purr purr yawn brown cats with pink ears.",
        cost: 3000
      })
    }
  }
}
