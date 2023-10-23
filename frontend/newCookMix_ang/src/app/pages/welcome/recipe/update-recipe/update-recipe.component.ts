import { Component } from '@angular/core';
import {Recipe} from "../../../../models/recipe";

import {RecipeService} from "../../../../serives/recipe/recipe.service";

@Component({
  selector: 'app-update-recipe',
  templateUrl: './update-recipe.component.html',
  styleUrls: ['./update-recipe.component.scss']
})
export class UpdateRecipeComponent {

  recipeId: number =0;
  updatedRecipe: Recipe = {};
  message: string = '';


  constructor(private recipeService: RecipeService) { }


  updateRecipe() {

  this.recipeService.updateRecipe(this.recipeId, this.updatedRecipe).subscribe(
(response) => {
  console.log('Recipe updated:', response);
  this.message = 'Recipe updated'
},
(error) => {
  console.error('Error updating recipe:', error);
  this.message = 'Error updating recipe'
                    }
       );
      }
  }
