import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Food} from "../../models/food";

@Injectable({
  providedIn: 'root'
})
export class FoodService {
  private pUrl = 'http://localhost:8089/api/v1/food'


  constructor(private http: HttpClient) {
  }



  fetchFoods(): Observable<Food[]> {
    return this.http.get<Food[]>(this.pUrl + '/all');
  }

  addFood(food:Food): Observable<Food> {
    return this.http.post<Food>(this.pUrl + '/add', food);
  }


  findFoodById(foodId: number): Observable<Food> {
    const url = `${this.pUrl}/${foodId}`;
    return this.http.get<Food>(url);

  }



}
