import { Component } from '@angular/core';
import {Recipe} from "../../../../models/recipe";
import {RecipeService} from "../../../../serives/recipe/recipe.service";

@Component({
  selector: 'app-find-recipe',
  templateUrl: './find-recipe.component.html',
  styleUrls: ['./find-recipe.component.scss']
})
export class FindRecipeComponent {

  founded : boolean = false;
  recipeId: number = 0;
  recipe: Recipe = {};
  message: string = '';

  constructor(private recipeService: RecipeService) {}

  fetchRecipeById() {
    this.recipeService.findRecipeById(this.recipeId).subscribe(
      (recipe) => {
        this.recipe = recipe;
        console.log('Fetched recipe:', this.recipe);
        this.message = 'Recipe found';
        this.founded = true;
      },
      (error) => {
        console.error('Error fetching recipe:', error);
        this.message = 'Error fetching recipe';
        this.founded = false;
      }
    );
  }
}
