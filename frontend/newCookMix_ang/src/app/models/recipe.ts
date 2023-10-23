
import {Ingredient} from "./ingredient";
import {Step} from "./step";

export interface Recipe {


  designation?: string;
  id?: number;
  ingredients?: Ingredient [];
  steps?: Step [];


}
