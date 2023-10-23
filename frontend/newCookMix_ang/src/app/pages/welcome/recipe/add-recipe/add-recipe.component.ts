import { Component } from '@angular/core';
import {Recipe} from "../../../../models/recipe";
import {RecipeService} from "../../../../serives/recipe/recipe.service";


@Component({
  selector: 'app-add-recipe',
  templateUrl: './add-recipe.component.html',
  styleUrls: ['./add-recipe.component.scss']
})
export class AddRecipeComponent {

  message: string = '';
  newRecipe: Recipe = {

    designation: '',
    steps: [{ id: 0, recipe: { id: 0 } }]
  };

  constructor(private recipeService: RecipeService) { }




  addRecipe() {
    this.recipeService.addRecipe(this.newRecipe).subscribe(
      (response) => {
        console.log('Recipe added:', response);
        this.message = 'Recipe added'
      },
      (error) => {
        console.error('Error adding recipe:', error);
        this.message = 'Error adding recipe'
      }
    );
  }

}
