import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { WelcomeComponent } from './pages/welcome/welcome.component';
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {AuthInterceptorProvider} from "./serives/authInterceptor";
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
import {AllInstructionComponent} from "./pages/welcome/instruction/all-instruction/all-instruction.component";
import {FindInstructionComponent} from "./pages/welcome/instruction/find-instruction/find-instruction.component";
import {AddInstructionComponent} from "./pages/welcome/instruction/add-instruction/add-instruction.component";
import {InstructionComponent} from "./pages/welcome/instruction/instruction.component";
import {
  AddIngredientStepComponent
} from "./pages/welcome/ingredient-step/add-ingredient-step/add-ingredient-step.component";
import {
  AllIngredientStepComponent
} from "./pages/welcome/ingredient-step/all-ingredient-step/all-ingredient-step.component";
import {IngredientStepComponent} from "./pages/welcome/ingredient-step/ingredient-step.component";
import {
  FindIngredientStepComponent
} from "./pages/welcome/ingredient-step/find-ingredient-step/find-ingredient-step.component";
import {IngredientComponent} from "./pages/welcome/ingredient/ingredient.component";
import {FindIngredientComponent} from "./pages/welcome/ingredient/find-ingredient/find-ingredient.component";
import {AddIngredientComponent} from "./pages/welcome/ingredient/add-ingredient/add-ingredient.component";
import {AllIngredientComponent} from "./pages/welcome/ingredient/all-ingredient/all-ingredient.component";
import {FoodComponent} from "./pages/welcome/food/food.component";
import {FindFoodComponent} from "./pages/welcome/food/find-food/find-food.component";
import {AllFoodComponent} from "./pages/welcome/food/all-food/all-food.component";
import {AddFoodComponent} from "./pages/welcome/food/add-food/add-food.component";










@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    WelcomeComponent,
    AddRecipeComponent,
    AllRecipeComponent,
    RecipeComponent,
    UpdateRecipeComponent,
    FindRecipeComponent,
    DeleteRecipeComponent,
    StepComponent,
    AddStepComponent,
    AllStepComponent,
    FindStepComponent,
    AllInstructionComponent,
    FindInstructionComponent,
    AddInstructionComponent,
    InstructionComponent,
    IngredientStepComponent,
    AddIngredientStepComponent,
    AllIngredientStepComponent,
    FindIngredientStepComponent,
    IngredientComponent,
    FindIngredientComponent,
    AllIngredientComponent,
    AddIngredientComponent,
    FoodComponent,
    AllFoodComponent,
    FindFoodComponent,
    AddFoodComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [AuthInterceptorProvider,
    HttpClient
  ],
  bootstrap: [AppComponent]

})
export class AppModule { }
