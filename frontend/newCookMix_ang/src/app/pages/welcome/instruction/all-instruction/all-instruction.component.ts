import { Component } from '@angular/core';
import {Instruction} from "../../../../models/instruction";
import {InstructionService} from "../../../../serives/instruction/instruction.service";

@Component({
  selector: 'app-all-instruction',
  templateUrl: './all-instruction.component.html',
  styleUrls: ['./all-instruction.component.scss']
})
export class AllInstructionComponent {
  instructions: Instruction[] = [];
  message: string = '';

  constructor(private instructionService: InstructionService) { }

  ngOnInit(): void {
    this.fetchInstructions();
  }

  fetchInstructions(): void {
    this.instructionService.fetchInstructions()
      .subscribe(
        (instructions: Instruction[]) => {
          this.instructions = instructions;
          this.message = 'Instructions fetched successfully';
          console.log('Fetching instructions:', instructions);
        },
        (error) => {
          console.error('Error fetching instructions:', error);
          this.message = 'Error fetching instructions';
        }
      );
  }
}
