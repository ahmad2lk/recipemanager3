import {IngredientStep} from "./ingredientStep";


export  interface  Ingredient{

  id? : number ;
  quantity? : string;
  unit?: string;
  recipe: {
    id: number;
  };
  ingredientSteps?: IngredientStep[];
  food: {
    id: number;
  };
}
