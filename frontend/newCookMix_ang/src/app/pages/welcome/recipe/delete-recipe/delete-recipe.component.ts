import { Component } from '@angular/core';
import {RecipeService} from "../../../../serives/recipe/recipe.service";


@Component({
  selector: 'app-delete-recipe',
  templateUrl: './delete-recipe.component.html',
  styleUrls: ['./delete-recipe.component.scss']
})
export class DeleteRecipeComponent {


  recipeId: number = 0;
  message = '';

 constructor( private recipeService: RecipeService) {
 }




  deleteRecipe(recipeId: number) {
    this.recipeService.deleteRecipe(recipeId).subscribe(
      () => {
        this.message = 'Recipe deleted successfully';
        console.log('Recipe deleted successfully.');
      },
      (error) => {
        this.message = 'Error deleting recipe';
        console.error('Error deleting recipe:', error);
      }
    );
  }
}
