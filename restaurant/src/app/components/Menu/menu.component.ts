import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeroComponent } from '../Hero/hero.component';

import { DividerModule } from 'primeng/divider';
import { ButtonModule } from 'primeng/button';
import { Food } from 'src/app/generated-api/model/food';
import { FoodRecipeInner } from 'src/app/generated-api/model/foodRecipeInner';


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
        id: i.toString(),
        name: `Dish `+i,
        type: this.foodLabelList[i],
        price: 3000
      })
    }
  }

  foodRecipeToDescription(recipe?: Array<FoodRecipeInner>){
    var description= ""
    if(recipe == null) return ""
    else
      recipe.forEach(function (item){
        description.concat(item.ingerient!)
      })
      return description
    }
  }
