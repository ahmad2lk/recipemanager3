import { Component } from '@angular/core';
import {IngredientStep} from "../../../../models/ingredientStep";
import {IngredientStepService} from "../../../../serives/ ingredientStep /ingredient-step.service";

@Component({
  selector: 'app-add-ingredient-step',
  templateUrl: './add-ingredient-step.component.html',
  styleUrls: ['./add-ingredient-step.component.scss']
})
export class AddIngredientStepComponent {


  message: string = '';

  newIngredientStep: IngredientStep = {
    id: 0,
    quantity: 0,
    unit: '',
    presentation: '',
    ingredient : {
      id:0
    },
    step: {
      id :0
    },
    food : {
      id:0
    }

  };

  constructor(private ingredientStepService: IngredientStepService) {}



  addNewIngredientStep() {
    this.ingredientStepService.addIngredientStep(this.newIngredientStep)
      .subscribe(
      (response) => {
        this.message = 'Ingredient step added successfully';

        console.error('Ingredient step added successfully:', response);
      },
      (error) => {
        console.error('Error adding ingredient step:', error);
        this.message = 'Error adding ingredient step';

      }
    );
  }
}
