import { Component,OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeroComponent } from '../Hero/hero.component';
import { DrinkStockItem, FoodStockItem } from 'src/app/generated-api';
import {  TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { InputNumberModule } from 'primeng/inputnumber';
import { DropdownModule } from 'primeng/dropdown';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { DialogModule } from 'primeng/dialog';
import { DefaultService } from 'src/app/generated-api/api/default.service';

@Component({
  selector: 'app-ingredients',
  standalone: true,
  imports: [CommonModule, HeroComponent, TableModule, ButtonModule, InputTextModule,DialogModule, InputNumberModule, DropdownModule,ReactiveFormsModule, FormsModule ],
  templateUrl: './ingredients.component.html',
  styleUrls: ['./ingredients.component.scss'],
})
export class IngredientsComponent implements OnInit {
  ingredients: FoodStockItem[] =[]
  editedItem!: FoodStockItem 
  ingredientsDrink: DrinkStockItem[] | undefined
  units=[
    FoodStockItem.UnitEnum.Kg,
    FoodStockItem.UnitEnum.Liter,
    FoodStockItem.UnitEnum.G,
    FoodStockItem.UnitEnum.Dkg,
    FoodStockItem.UnitEnum.Dl,   
  ]

  newIngredientFormOpen = false
  food: boolean = true

  clonedFoodStockItem: { [s: string]: FoodStockItem } = {};

  newIngredientForm = new FormGroup({
    name: new FormControl('', [Validators.required]),
    quantity: new FormControl(1, Validators.required),
    unit: new FormControl(FoodStockItem.UnitEnum.Kg),
  })

  constructor(private ingredientService: DefaultService){}

  ngOnInit(): void {
      this.ingredients = new Array()
      this.ingredientService.getAllFoodStockItems().subscribe(
        (result)=> this.ingredients=result
      )

      this.ingredientService.getAllDrinkStockItems().subscribe(
        (result)=> this.ingredientsDrink=result
      )
  }

  onRowEditInit(item: FoodStockItem) {
    this.clonedFoodStockItem[item.id as string] = { ...item };
  }

  onRowEditSave(item: FoodStockItem) {
    console.log(item)
    this.ingredientService.partiallyUpdateFoodStockItem(item.id!, item.name, item.quantity).subscribe(
      (result)=>{}
    )
  }

  onRowEditCancel(item: FoodStockItem, index: number) {
    this.ingredients![index] = this.clonedFoodStockItem[item.id as string];
    delete this.clonedFoodStockItem[item.id as string];
  }

  newIngredientFormOpenBtnClick(){
    this.newIngredientFormOpen = true
  }

  deleteIngredientFood(ingredient: FoodStockItem ){
    this.ingredientService.deleteFoodStockItem(ingredient.id!).subscribe(
      (result)=>{
        this.ngOnInit()
      }
    )
    
  }

  onSubmit(){
    if(this.food){
      var newFoodStockItem = {
        name: this.newIngredientForm.value.name!,
        quantity: this.newIngredientForm.value.quantity!,
        unit: this.newIngredientForm.value.unit!
      }

      console.log(newFoodStockItem)

      this.ingredientService.createFoodStockItem(newFoodStockItem).subscribe(
        (result)=>{
           alert("Success!")
           this.newIngredientFormOpen=false
           this.ngOnInit()
        }
      )
    }

    else{
      var newDrinkStockItem={
        name: this.newIngredientForm.value.name!,
        quantity: this.newIngredientForm.value.quantity!,
      }

      this.ingredientService.createDrinkStockItem(newDrinkStockItem).subscribe(
        (result)=> {
          alert("Success!")
          this.newIngredientFormOpen=false
          this.ngOnInit()
       }
      )
    }
  }
}
