import { Component } from '@angular/core';
import {IngredientStep} from "../../../../models/ingredientStep";
import {IngredientStepService} from "../../../../serives/ ingredientStep /ingredient-step.service";

@Component({
  selector: 'app-find-ingredient-step',
  templateUrl: './find-ingredient-step.component.html',
  styleUrls: ['./find-ingredient-step.component.scss']
})
export class FindIngredientStepComponent {


  message: string = '';
  ingredientStepId: number = 0;


    selectedIngredientStep: IngredientStep = {

      id: 0,
      quantity: 0,
      unit: '',
      presentation: '',
      ingredient: {
        id: 0
      },
      step: {
        id: 0
      },
      food: {
        id: 0
      }
    };


  constructor(private ingredientStepService: IngredientStepService) { }

  findIngredientStepById(ingredientStepId: number) {
    this.ingredientStepService.findIngredientStepById(ingredientStepId).subscribe(
      (ingredientStep: IngredientStep) => {
        this.selectedIngredientStep = ingredientStep;
        this.message = 'Fetching ingredient step details successfully';
      },
      (error) => {
        console.error('Error fetching ingredient step details:', error);
      }
    );
  }
}
