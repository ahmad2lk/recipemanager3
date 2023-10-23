import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Instruction} from "../../models/instruction";

@Injectable({
  providedIn: 'root'
})
export class InstructionService {

  private pUrl = 'http://localhost:8089/api/v1/instruction'


  constructor(private http: HttpClient) {
  }



  fetchInstructions(): Observable<Instruction[]> {
    return this.http.get<Instruction[]>(this.pUrl + '/all');
  }

  addInstruction(instruction:Instruction): Observable<Instruction> {
    return this.http.post<Instruction>(this.pUrl + '/add', instruction);
  }


  findInstructionById(instructionId: number): Observable<Instruction> {
    const url = `${this.pUrl}/${instructionId}`;
    return this.http.get<Instruction>(url);

  }



}
