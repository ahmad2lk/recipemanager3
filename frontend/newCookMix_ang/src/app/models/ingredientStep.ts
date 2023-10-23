


export interface IngredientStep {
  id?: number;
  quantity?: number;
  unit?: string;
  presentation?: string;
  ingredient : {
    id:number;
  }
  step: {
    id : number
}
  food : {
    id:number
  }
}
