import { Component } from '@angular/core';
import {Ingredient} from "../../../../models/ingredient";
import {IngredientService} from "../../../../serives/ingredient/ingredient.service";

@Component({
  selector: 'app-find-ingredient',
  templateUrl: './find-ingredient.component.html',
  styleUrls: ['./find-ingredient.component.scss']
})
export class FindIngredientComponent {
  message: string = '';
  ingredientId: number = 0;
  selectedIngredient: Ingredient = {

    id: 0,
    quantity: '',
    unit: '',
    recipe: { id: 0 },
    food: { id: 0 }
  };

  constructor(private ingredientService: IngredientService) { }



  findIngredient(ingredientId: number) {
    this.ingredientService.findIngredientById(ingredientId).subscribe(
      (ingredient: Ingredient) => {
        this.selectedIngredient = ingredient;
        this.message = 'Fetching ingredient details successfully';
      },
      (error) => {
        console.error('Error fetching ingredient details:', error);
      }
    );
  }
}
