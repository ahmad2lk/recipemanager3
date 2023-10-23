import { Component } from '@angular/core';
import {Food} from "../../../../models/food";
import {FoodService} from "../../../../serives/food/food.service";

@Component({
  selector: 'app-all-food',
  templateUrl: './all-food.component.html',
  styleUrls: ['./all-food.component.scss']
})
export class AllFoodComponent {
  message: string = '';
  allFood: Food[] = [];

  constructor(private foodService: FoodService) {}

  ngOnInit(): void {
    this.loadAllFood();
  }

  loadAllFood() {
    this.foodService.fetchFoods().subscribe(
      (foods: Food[]) => {
        this.allFood = foods;
        this.message = 'Fetching all foods successfully';
      },
      (error) => {
        console.error('Error fetching foods:', error);
        this.message = 'Error fetching foods';
      }
    );
  }
}
