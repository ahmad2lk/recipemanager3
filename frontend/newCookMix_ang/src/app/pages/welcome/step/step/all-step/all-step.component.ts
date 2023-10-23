import { Component } from '@angular/core';
import {Step} from "../../../../../models/step";
import {StepService} from "../../../../../serives/step/step.service";

@Component({
  selector: 'app-all-step',
  templateUrl: './all-step.component.html',
  styleUrls: ['./all-step.component.scss']
})
export class AllStepComponent {
  steps: Step[] = [];
  message: string = '';

  constructor(private stepService :StepService) { }

  ngOnInit(): void {
    this.fetchSteps();
  }

  fetchSteps():void {
    this.stepService.fetchSteps().subscribe(
      (steps) => { // Correct the parameter name here
        this.steps = steps;
        this.message = 'Steps fetched successfully';
        console.error(' fetching Steps:', steps);
      },
      (error) => {
        console.error('Error fetching Steps:', error);
        this.message = 'Error fetching Steps';
      }
    );
  }
}
