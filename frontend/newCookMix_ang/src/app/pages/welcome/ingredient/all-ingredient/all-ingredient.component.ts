import { Component } from '@angular/core';
import {Ingredient} from "../../../../models/ingredient";
import {IngredientService} from "../../../../serives/ingredient/ingredient.service";

@Component({
  selector: 'app-all-ingredient',
  templateUrl: './all-ingredient.component.html',
  styleUrls: ['./all-ingredient.component.scss']
})
export class AllIngredientComponent {

  message: string = '';
  ingredients: Ingredient[] = [];
  constructor(private ingredientService: IngredientService) {}

  ngOnInit(): void {
    this.loadIngredients();
  }

  loadIngredients() {
    this.ingredientService.fetchIngredients().subscribe(
      (ingredients: Ingredient[]) => {
        this.ingredients = ingredients;
        this.message = ' fetching ingredients successfully'
      },
      (error) => {
        console.error('Error fetching ingredients:', error);
        this.message = ' Error fetching ingredients'
      }
    );
  }
}
