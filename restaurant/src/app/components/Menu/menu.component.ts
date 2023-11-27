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
import { StoreUserService } from 'src/app/generated-api/api/store.service';
import { ResizableColumn } from 'primeng/table';
import { CartService } from 'src/app/services/cart.service';
import { DefaultService } from 'src/app/generated-api/api/default.service';


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
  drinkTypeList=[
    Drink.TypeEnum.AlcoholicDrink,
    Drink.TypeEnum.SoftDrink,
    Drink.TypeEnum.HotDrink
  ]
  drinkList: Drink[] | undefined
  dialogVisible: boolean=false
  updateDialogVisible: boolean=false
  food: boolean = true
  ingredientList!: FoodStockItem[]
  updateMenuItem = new FormGroup({
    name: new FormControl('', [Validators.required]),
    price: new FormControl(0, [Validators.required]),
  })
  newMenuItem = new FormGroup({
    name: new FormControl('', [Validators.required]),
    price: new FormControl(0, [Validators.required]),
    ingredients: new FormControl(),
    typeFood: new FormControl(Food.TypeEnum.Soup),
    typeDrink: new FormControl(Drink.TypeEnum.SoftDrink),
  })

  updateingId: string | undefined

  constructor(private menuService: MenuService,
              private storeUserService: StoreUserService,
              private cartService: CartService,
              private ingredientService: DefaultService){}

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

    this.ingredientService.getAllFoodStockItems().subscribe(
      (result)=>{
        this.ingredientList=result
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
      if(this.storeUserService.isLoggedIn()){
        for(let role of roles){
          if(this.storeUserService.hasRole(role)){
            return true;
          }
        }
      }
      return false;
    }

    addCart(food: boolean, index: number){
      if(food){
        this.cartService.addFood(this.foodList![index], -1)
        window.alert("The item has been added to the cart!")
      }
      else{
        this.cartService.addDrink(this.drinkList![index], -1)
        window.alert("The item has been added to the cart!")
      }
    }

    addNewMenuItem(){
      this.dialogVisible=true
    }

    onSubmit(){
      if(this.food){
        let food: Food={
          id: "0",
          name: this.newMenuItem.value.name!,
          type: this.newMenuItem.value.typeFood!,
          price: this.newMenuItem.value.price!,
          recipe: this.createRecipe(this.newMenuItem.value.ingredients)
        }

        this.menuService.addFoodToMenu(food).subscribe(
          (result)=>{
              this.dialogVisible=false;
              this.ngOnInit()
          }
        )
      }
      else{
        let drink: Drink ={
          id:"0",
          name: this.newMenuItem.value.name!,
          type: this.newMenuItem.value.typeDrink!,
          price: this.newMenuItem.value.price!,
        }


        this.menuService.addDrinkToMenu(drink).subscribe(
          (result)=>{
              this.dialogVisible=false
          }
        )
      }
    }

    createRecipe(ingredients:  FoodStockItem[]){
      var recipe = new Array<FoodRecipeInner>
      ingredients.forEach(i =>{
        recipe.push({
          ingerient: i.name,
          unit: i.unit,
          quantity: 1
        })
      })
      return recipe
    }

    typeEnumString(type: String){
      return type.charAt(0).toUpperCase()+type.slice(1)
    }

    deleteMenuItem_Food(food: Food){
      this.menuService.deleteFood(food.id).subscribe(
        (result)=>{
          alert("Successfully deleted food!")
          this.ngOnInit()
        }
      )
    }

    deleteMenuItem_Drink(drink: Drink){
      this.menuService.deleteDrink(drink.id).subscribe(
        (result)=>{
          alert("Successfully deleted drink!")
          this.ngOnInit()
        }
      )
    }

    updateMenuItem_Drink(drink: Drink){
      this.updateingId=drink.id
      this.updateDialogVisible=true
      this.food=false
      this.updateMenuItem.setValue({
        name: drink.name,
        price:drink.price,
      })
    }

    updateMenuItem_Food(food: Food){
      this.updateingId=food.id
      this.updateDialogVisible=true
      this.food=true
      this.updateMenuItem.setValue({
        name: food.name,
        price: food.price,
      })
    }

    onSubmitUpdate(){
      if(this.food)
{      var food={
        name:this.updateMenuItem.value.name!,
        price: this.updateMenuItem.value.price!
      }
      console.log(food)
      this.menuService.updateFood(this.updateingId!, food.name, food.price).subscribe(
        (result)=>
      {  this.updateDialogVisible=false
        this.updateingId=undefined
        this.ngOnInit()}
      )
    }
    else{
      var drink={
        name:this.updateMenuItem.value.name!,
        price: this.updateMenuItem.value.price!
      }
      this.menuService.updateDrink(this.updateingId!, drink.name, drink.price).subscribe(
        (result)=>
      {  this.updateDialogVisible=false
        this.updateingId=undefined
      this.ngOnInit()}
      )
    }
  }
  }