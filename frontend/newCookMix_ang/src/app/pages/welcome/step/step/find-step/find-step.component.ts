import { Component } from '@angular/core';
import {Step} from "../../../../../models/step";
import {StepService} from "../../../../../serives/step/step.service";

@Component({
  selector: 'app-find-step',
  templateUrl: './find-step.component.html',
  styleUrls: ['./find-step.component.scss']
})
export class FindStepComponent {
  founded : boolean = false;
  stepId: number = 0;
 step: Step = <Step>{};
  message: string = '';
  constructor(private stepService :StepService) { }


  findStep():void {
    this.stepService.findStepById(this.stepId)
      .subscribe(
      (step) => { // Correct the parameter name here
        this.step = step;
        this.founded = true;
        this.message = 'Step fetched successfully';
        console.error(' fetching Step:', step);
      },
      (error) => {
        console.error('Error fetching Step:', error);
        this.message = 'Error fetching Step';
      }
    );
  }
}
