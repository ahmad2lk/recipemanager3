import { Component } from '@angular/core';
import {Step} from "../../../../../models/step";
import {StepService} from "../../../../../serives/step/step.service";

@Component({
  selector: 'app-add-step',
  templateUrl: './add-step.component.html',
  styleUrls: ['./add-step.component.scss']
})
export class AddStepComponent {
  message: string = '';
  newStep: Step = {
    ingredientSteps: [],
    instructions: [],
    recipe: {
      id: 0
    }

  };

  constructor(private stepService: StepService) { }



  addStep() {
    this.stepService.addStep(this.newStep)
      .subscribe(
        (response) => {
          console.log('Step added:', response);
          this.message = 'Step added'
        },
        (error) => {
          console.error('Error adding Step:', error);
          this.message = 'Error adding Step'
        }
      );

  }
}
