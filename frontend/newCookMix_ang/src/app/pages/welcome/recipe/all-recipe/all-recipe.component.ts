import {Component, OnInit} from '@angular/core';
import {Recipe} from "../../../../models/recipe";
import {RecipeService} from "../../../../serives/recipe/recipe.service";


@Component({
  selector: 'app-all-recipe',
  templateUrl: './all-recipe.component.html',
  styleUrls: ['./all-recipe.component.scss']
})
export class AllRecipeComponent  implements OnInit{
  recipes: Recipe[] = [];
  message: string = '';

  constructor(private recipeService: RecipeService) { }

  ngOnInit(): void {
    this.fetchRecipes();
  }

  fetchRecipes():void {
    this.recipeService.fetchRecipes().subscribe(
      (recipes) => { // Correct the parameter name here
        this.recipes = recipes;
        this.message = 'Recipes fetched successfully';
      },
      (error) => {
        console.error('Error fetching recipes:', error);
        this.message = 'Error fetching recipes';
      }
    );
  }
}
