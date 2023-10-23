import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Step} from "../../models/step";

@Injectable({
  providedIn: 'root'
})
export class StepService {
  private pUrl = 'http://localhost:8089/api/v1/step'


  constructor(private http: HttpClient) {
  }



  fetchSteps(): Observable<Step[]> {
    return this.http.get<Step[]>(this.pUrl + '/all');
  }

  addStep(step:Step): Observable<Step> {
    return this.http.post<Step>(this.pUrl + '/add', step);
  }


  findStepById(stepId: number): Observable<Step> {
    const url = `${this.pUrl}/${stepId}`;
    return this.http.get<Step>(url);

  }



}
