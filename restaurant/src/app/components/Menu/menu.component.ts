import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeroComponent } from '../Hero/hero.component';
import { RadioButtonModule } from 'primeng/radiobutton';
import { DividerModule } from 'primeng/divider';
import { ButtonModule } from 'primeng/button';
import { Food } from 'src/app/generated-api/model/food';
import { FoodRecipeInner } from 'src/app/generated-api/model/foodRecipeInner';
import { Drink, FoodStockItem, MenuService } from 'src/app/generated-api';
import { AuthService } from 'src/app/generated-api/api/auth.service';
import { DialogModule } from 'primeng/dialog';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MultiSelectModule } from 'primeng/multiselect';
import { Dropdown, DropdownModule } from 'primeng/dropdown';


@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [CommonModule, HeroComponent, DividerModule, ButtonModule, DialogModule, ButtonModule, RadioButtonModule, FormsModule, ReactiveFormsModule, MultiSelectModule, DropdownModule ],
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss'],
})
export class MenuComponent implements OnInit {
  foodList: Food[ ] | undefined
  foodTypeList=[
    Food.TypeEnum.Soup,
    Food.TypeEnum.SideDish,
    Food.TypeEnum.MainCourse,
    Food.TypeEnum.Dessert
  ]
  drinkList: Drink[] | undefined
  dialogVisible: boolean=true
  food!: boolean
  ingredientList!: FoodStockItem[]
  newMenuItem = new FormGroup({
    name: new FormControl('', [Validators.required]),
    price: new FormControl(0, [Validators.required]),
    ingredients: new FormControl([]),
    type: new FormControl(Food.TypeEnum.Soup, [Validators.required]),
  })

  constructor(private authService: AuthService,private menuService: MenuService){}

  ngOnInit(): void{
    this.foodList= new Array<Food>
    this.drinkList= new Array<Drink>
    this.ingredientList= new Array<FoodStockItem>

    this.menuService.getFoodMenu().subscribe(
      (result)=>{
        this.foodList=result
      },
    )
    this.menuService.getDrinkMenu().subscribe(
      (result)=>{
        this.drinkList=result;
      }
    )
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

    hasOneOfTheRoles(roles: string[]): boolean{
        //TODO
      return true;
    }

    addCart(food: boolean, index: number){

    }

    addNewMenuItem(){
      this.dialogVisible=true
    }

    foodTypeEnumString(type: String){
      return type.charAt(0).toUpperCase()+type.slice(1)
    }
  }


