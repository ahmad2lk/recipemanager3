import {IngredientStep} from "./ingredientStep";
import {Instruction} from "./instruction";
import {Recipe} from "./recipe";

export interface Step {


  id?: number;
  ingredientSteps?: IngredientStep[];
  instructions? : Instruction [];
  recipe: {
    id: number;
  };
}
