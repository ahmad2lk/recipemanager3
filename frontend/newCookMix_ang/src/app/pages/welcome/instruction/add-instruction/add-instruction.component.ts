import { Component } from '@angular/core';
import {InstructionService} from "../../../../serives/instruction/instruction.service";
import {Instruction} from "../../../../models/instruction";


@Component({
  selector: 'app-add-instruction',
  templateUrl: './add-instruction.component.html',
  styleUrls: ['./add-instruction.component.scss']
})
export class AddInstructionComponent {
  newInstruction: Instruction = {
    description: '',
    type: '',
    step: {
      id: 0
    }
  };
  message: string = '';

  constructor(private instructionService: InstructionService) {}

  addInstruction(): void {
    this.instructionService.addInstruction(this.newInstruction)
      .subscribe(
        (instruction) => {
          console.log('Instruction added:', instruction);
          this.message = 'Instruction added successfully';
        },
        (error) => {
          console.error('Error adding Instruction:', error);
          this.message = 'Error adding Instruction';
        }
      );
  }
}
