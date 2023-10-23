import { Component } from '@angular/core';
import {FoodService} from "../../../../serives/food/food.service";
import {Food} from "../../../../models/food";

@Component({
  selector: 'app-add-food',
  templateUrl: './add-food.component.html',
  styleUrls: ['./add-food.component.scss']
})
export class AddFoodComponent {

  message: string = '';
  newFood: Food = {
    consistency: '',
    unit: '',
    ingredients: [],
    ingredientSteps: []
  };

  constructor(private foodService: FoodService) { }

  addFood() {
    this.foodService.addFood(this.newFood).subscribe(
      (response) => {
        console.log('Food added:', response);
        this.message = 'Food added successfully';

      },
      (error) => {
        console.error('Error adding food:', error);
        this.message = 'Error adding food';
      }
    );
  }
}
