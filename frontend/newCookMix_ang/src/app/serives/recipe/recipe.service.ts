import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Recipe} from "../../models/recipe";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  private pUrl = 'http://localhost:8089/api/v1/recipe'


  constructor(private http: HttpClient) {
  }



  fetchRecipes(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(this.pUrl + '/all');
  }

  addRecipe(recipe: Recipe): Observable<Recipe> {
    return this.http.post<Recipe>(this.pUrl + '/add', recipe);
  }

  updateRecipe(recipeId: number, updatedRecipe: Recipe): Observable<any> {
    const url = this.pUrl + '/update';
    return this.http.put(url, updatedRecipe);
  }
  findRecipeById(recipeId: number): Observable<Recipe> {
    const url = `${this.pUrl}/${recipeId}`;
    return this.http.get<Recipe>(url);

  }


  deleteRecipe(recipeId: number) {
    const url = `${this.pUrl}/delete/${recipeId}`;
    return this.http.delete<void>(url);
  }
}
