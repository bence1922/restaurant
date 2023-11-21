import { Component,OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeroComponent } from '../Hero/hero.component';
import { Food, FoodStockItem } from 'src/app/generated-api';
import { SortableColumn, TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { InputNumberModule } from 'primeng/inputnumber';
import { DropdownModule } from 'primeng/dropdown';

@Component({
  selector: 'app-ingredients',
  standalone: true,
  imports: [CommonModule, HeroComponent, TableModule, ButtonModule, InputTextModule, InputNumberModule, DropdownModule],
  templateUrl: './ingredients.component.html',
  styleUrls: ['./ingredients.component.scss'],
})
export class IngredientsComponent implements OnInit {
  ingredients: FoodStockItem[] | undefined 
  editedItem!: FoodStockItem 
  units!: FoodStockItem.UnitEnum[]
  newIngredientFormOpen = false
  newFoodStockItem = {
    name: "",
    quantity: 0,
    unit: FoodStockItem.UnitEnum.Kg
  }

  ngOnInit(): void {
      this.ingredients = new Array()
      for(let i = 0; i < 3; i++){
        this.ingredients.push({
          name: "Ingredient "+i,
          quantity: 100,
          unit: FoodStockItem.UnitEnum.Kg     
        })
      }

      this.units=[
        FoodStockItem.UnitEnum.Kg,
        FoodStockItem.UnitEnum.Liter,
        FoodStockItem.UnitEnum.G,
        FoodStockItem.UnitEnum.Dkg,
        FoodStockItem.UnitEnum.Dl,   
      ]
  }

  onRowEditInit(item: FoodStockItem) {
  }

  onRowEditSave(item: FoodStockItem) {

  }

  onRowEditCancel(item: FoodStockItem, index: number) {

  }

  newIngredientFormOpenBtnClick(){
    this.newIngredientFormOpen = ! this.newIngredientFormOpen
  }
}
