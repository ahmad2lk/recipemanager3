import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Ingredient} from "../../models/ingredient";

@Injectable({
  providedIn: 'root'
})
export class IngredientService {
  private pUrl = 'http://localhost:8089/api/v1/ingredient'


  constructor(private http: HttpClient) {
  }



  fetchIngredients(): Observable<Ingredient[]> {
    return this.http.get<Ingredient[]>(this.pUrl + '/all');
  }

  addIngredient(ingredient:Ingredient): Observable<Ingredient> {
    return this.http.post<Ingredient>(this.pUrl + '/add', ingredient);
  }


  findIngredientById(ingredientId: number): Observable<Ingredient> {
    const url = `${this.pUrl}/${ingredientId}`;
    return this.http.get<Ingredient>(url);

  }



}
