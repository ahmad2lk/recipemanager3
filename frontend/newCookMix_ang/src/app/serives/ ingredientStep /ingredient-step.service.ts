import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {IngredientStep} from "../../models/ingredientStep";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class IngredientStepService {
  private pUrl = 'http://localhost:8089/api/v1/ingredientStep'


  constructor(private http: HttpClient) {
  }



  fetchIngredientSteps(): Observable<IngredientStep[]> {
    return this.http.get<IngredientStep[]>(this.pUrl + '/all');
  }

  addIngredientStep(ingredientStep:IngredientStep): Observable<IngredientStep> {
    return this.http.post<IngredientStep>(this.pUrl + '/add', ingredientStep);
  }


  findIngredientStepById(ingredientStepId: number): Observable<IngredientStep> {
    const url = `${this.pUrl}/${ingredientStepId}`;
    return this.http.get<IngredientStep>(url);

  }



}
