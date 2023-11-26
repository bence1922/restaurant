import { Injectable } from '@angular/core';
import { Drink, DrinkOrderItem, Food, FoodOrderItem } from '../generated-api';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private foodsKey = 'foods';
  private drinksKey = 'drinks';

  foods: FoodOrderItem[] = [];
  drinks: DrinkOrderItem[] = [];

  constructor(private cookieService: CookieService) {
    // Load data from cookies on service initialization
    this.foods = JSON.parse(this.cookieService.get(this.foodsKey) || '[]');
    this.drinks = JSON.parse(this.cookieService.get(this.drinksKey) || '[]');
  }

  getFoods(){
    return this.foods
  }

  getDrinks(){
    return this.drinks
  }

  addFood(food:Food, index: number){
    if(!this.increase(true, index)){
      let item: FoodOrderItem = {
        food: food,
        quantity: 1
      }
      this.foods.push(item)
      this.saveToCookies()
    }
  }

  addDrink(drink: Drink, index: number){
    if(!this.increase(false, index)){
      let item: DrinkOrderItem = {
        drink: drink,
        quantity: 1
      }
      this.drinks.push(item)
      this.saveToCookies()
    }
  }

  increase(food: boolean, index: number){
    if(food){
      if(index==-1){
        this.foods[index].quantity++
        this.saveToCookies()
        return true
      }
    }else{
      this.drinks[index].quantity++
      this.saveToCookies()
      return true
    }

    return false
  }

  decrease(food: boolean, index: number){
    if(food){
      this.foods[index].quantity--
      if(this.foods[index].quantity==0){
        this.foods.splice(index, 1)
      }
    }
    else{
      this.drinks[index].quantity--
      if(this.drinks[index].quantity==0){
        this.drinks.splice(index, 1)
      }
    }

    this.saveToCookies()
  }

  clearCart(){
    this.foods=[]
    this.drinks=[]
  }

  private saveToCookies() {
    // Set cookies with the updated data
    this.cookieService.set(this.foodsKey, JSON.stringify(this.foods));
    this.cookieService.set(this.drinksKey, JSON.stringify(this.drinks));
  }
}
