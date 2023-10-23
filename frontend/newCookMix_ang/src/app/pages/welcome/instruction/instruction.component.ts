import {Component, OnInit} from '@angular/core';
import {Step} from "../../../models/step";
import {StepService} from "../../../serives/step/step.service";
import {Instruction} from "../../../models/instruction";
import {InstructionService} from "../../../serives/instruction/instruction.service";

@Component({
  selector: 'app-instruction',
  templateUrl: './instruction.component.html',
  styleUrls: ['./instruction.component.scss']
})
export class InstructionComponent {
}
