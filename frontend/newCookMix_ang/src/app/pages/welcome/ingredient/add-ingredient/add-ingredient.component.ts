import { Component } from '@angular/core';
import {Ingredient} from "../../../../models/ingredient";
import {IngredientService} from "../../../../serives/ingredient/ingredient.service";

@Component({
  selector: 'app-add-ingredient',
  templateUrl: './add-ingredient.component.html',
  styleUrls: ['./add-ingredient.component.scss']
})
export class AddIngredientComponent {
  message: string = '';
  newIngredient: Ingredient = {
    quantity: '',
    unit: '',
    recipe: { id: 0 },
    food: { id: 0 }
  };

  constructor(private ingredientService: IngredientService) { }

  addIngredient() {
    this.ingredientService.addIngredient(this.newIngredient).subscribe(
      (response) => {
        console.log('Ingredient added:', response);
        this.message = 'Ingredient added'
      },
      (error) => {
        console.error('Error adding ingredient:', error);
        this.message = 'Error adding ingredient'
      }
    );
  }
}



