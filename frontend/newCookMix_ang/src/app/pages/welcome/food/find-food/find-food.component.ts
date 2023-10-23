import { Component } from '@angular/core';
import {Food} from "../../../../models/food";
import {FoodService} from "../../../../serives/food/food.service";

@Component({
  selector: 'app-find-food',
  templateUrl: './find-food.component.html',
  styleUrls: ['./find-food.component.scss']
})
export class FindFoodComponent {
  message: string = '';
  foodId: number = 0;
  selectedFood: Food ={
    consistency: '',
    unit: '',
    ingredients: [],
    ingredientSteps: []
  }

  constructor(private foodService: FoodService) {}

  findFoodById() {
    this.foodService.findFoodById(this.foodId).subscribe(
      (food: Food) => {
        this.selectedFood = food;
        this.message = 'Found food details successfully';
      },
      (error) => {
        console.error('Error fetching food details:', error);
        this.message = 'Error fetching food details';
      }
    );
  }
}
