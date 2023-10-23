import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./pages/login/login.component";
import {RegisterComponent} from "./pages/register/register.component";
import {WelcomeComponent} from "./pages/welcome/welcome.component";
import {authGuard} from "./serives/auth/auth.guard";

import {RecipeComponent} from "./pages/welcome/recipe/recipe.component";
import {AddRecipeComponent} from "./pages/welcome/recipe/add-recipe/add-recipe.component";
import {AllRecipeComponent} from "./pages/welcome/recipe/all-recipe/all-recipe.component";
import {UpdateRecipeComponent} from "./pages/welcome/recipe/update-recipe/update-recipe.component";
import {FindRecipeComponent} from "./pages/welcome/recipe/find-recipe/find-recipe.component";
import {DeleteRecipeComponent} from "./pages/welcome/recipe/delete-recipe/delete-recipe.component";
import {StepComponent} from "./pages/welcome/step/step/step.component";
import {AllStepComponent} from "./pages/welcome/step/step/all-step/all-step.component";
import {FindStepComponent} from "./pages/welcome/step/step/find-step/find-step.component";
import {AddStepComponent} from "./pages/welcome/step/step/add-step/add-step.component";
import {InstructionComponent} from "./pages/welcome/instruction/instruction.component";
import {FindInstructionComponent} from "./pages/welcome/instruction/find-instruction/find-instruction.component";
import {AllInstructionComponent} from "./pages/welcome/instruction/all-instruction/all-instruction.component";
import {AddInstructionComponent} from "./pages/welcome/instruction/add-instruction/add-instruction.component";
import {IngredientStepComponent} from "./pages/welcome/ingredient-step/ingredient-step.component";
import {
  AllIngredientStepComponent
} from "./pages/welcome/ingredient-step/all-ingredient-step/all-ingredient-step.component";
import {
  AddIngredientStepComponent
} from "./pages/welcome/ingredient-step/add-ingredient-step/add-ingredient-step.component";
import {
  FindIngredientStepComponent
} from "./pages/welcome/ingredient-step/find-ingredient-step/find-ingredient-step.component";
import {IngredientComponent} from "./pages/welcome/ingredient/ingredient.component";
import {AllIngredientComponent} from "./pages/welcome/ingredient/all-ingredient/all-ingredient.component";
import {AddIngredientComponent} from "./pages/welcome/ingredient/add-ingredient/add-ingredient.component";
import {FindIngredientComponent} from "./pages/welcome/ingredient/find-ingredient/find-ingredient.component";
import {FoodComponent} from "./pages/welcome/food/food.component";
import {FindFoodComponent} from "./pages/welcome/food/find-food/find-food.component";
import {AllFoodComponent} from "./pages/welcome/food/all-food/all-food.component";
import {AddFoodComponent} from "./pages/welcome/food/add-food/add-food.component";


const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'welcome',
    component: WelcomeComponent,
    canActivate: [authGuard]
  },{
    path: 'all',
    component: AllRecipeComponent,
    canActivate: [authGuard]
  },
  {
    path: 'add',
    component: AddRecipeComponent,
    canActivate: [authGuard]
  }, {
    path: 'recipe',
    component: RecipeComponent,
    canActivate: [authGuard]
  } , {
    path: 'update',
    component: UpdateRecipeComponent,
    canActivate: [authGuard]
  },{
    path: 'find',
    component: FindRecipeComponent,
    canActivate: [authGuard]
  },{
    path: 'delete',
    component: DeleteRecipeComponent,
    canActivate: [authGuard]
  },{
    path: 'step',
    component: StepComponent,
    canActivate: [authGuard]
  },
  {
    path: 'step/all',
    component: AllStepComponent,
    canActivate: [authGuard]
  },{
    path: 'step/find',
    component: FindStepComponent,
    canActivate: [authGuard]
  },{
    path: 'step/add',
    component: AddStepComponent,
    canActivate: [authGuard]
  },{
    path: 'instruction',
    component: InstructionComponent,
    canActivate: [authGuard]
  },{
    path: 'instruction/find',
    component: FindInstructionComponent,
    canActivate: [authGuard]
  },{
    path: 'instruction/all',
    component:  AllInstructionComponent,
    canActivate: [authGuard] } ,
  {
    path: 'instruction/add',
    component: AddInstructionComponent,
    canActivate: [authGuard]
  },{
    path: 'ingredientStep',
    component: IngredientStepComponent,
    canActivate: [authGuard]
  },{
    path: 'ingredientStep/all',
    component: AllIngredientStepComponent,
    canActivate: [authGuard]
  },{
    path: 'ingredientStep/add',
    component: AddIngredientStepComponent,
    canActivate: [authGuard]
  },{
    path: 'ingredientStep/find',
    component: FindIngredientStepComponent,
    canActivate: [authGuard]
  },
  {
    path: 'ingredient',
    component: IngredientComponent,
    canActivate: [authGuard]
  }, {
    path: 'ingredient/all',
    component: AllIngredientComponent,
    canActivate: [authGuard]
  },{
    path: 'ingredient/add',
    component: AddIngredientComponent,
    canActivate: [authGuard]
  },{
    path: 'ingredient/find',
    component: FindIngredientComponent,
    canActivate: [authGuard]
  },
  {
    path: 'food',
    component: FoodComponent,
    canActivate: [authGuard]
  },{
    path: 'food/find',
    component: FindFoodComponent,
    canActivate: [authGuard]
  },{
    path: 'food/all',
    component: AllFoodComponent,
    canActivate: [authGuard]
  },{
    path: 'food/add',
    component: AddFoodComponent,
    canActivate: [authGuard]
  }




];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
