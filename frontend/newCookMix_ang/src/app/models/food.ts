import {IngredientStep} from "./ingredientStep";
import {Ingredient} from "./ingredient";

export  interface  Food {

  id? : number ;
  consistency? : string;
  unit?: string;
  ingredients?: Ingredient[];
  ingredientSteps?: IngredientStep[];

}
