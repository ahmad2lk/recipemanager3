import { Component } from '@angular/core';
import {IngredientStepService} from "../../../../serives/ ingredientStep /ingredient-step.service";
import {IngredientStep} from "../../../../models/ingredientStep";

@Component({
  selector: 'app-all-ingredient-step',
  templateUrl: './all-ingredient-step.component.html',
  styleUrls: ['./all-ingredient-step.component.scss']
})
export class AllIngredientStepComponent {

  message: string = '';
  allIngredientSteps: IngredientStep[] = [];

  constructor(private ingredientStepService: IngredientStepService) { }

  ngOnInit() {
    this.fetchAllIngredientSteps();
  }

  fetchAllIngredientSteps() {
    this.ingredientStepService.fetchIngredientSteps().subscribe(
      (ingredientSteps: IngredientStep[]) => {
        this.allIngredientSteps = ingredientSteps;
        this.message = 'fetching ingredientSteps successfully'
      },
      (error) => {
        console.error('Error fetching ingredientSteps:', error);
      }
    );
  }
}
