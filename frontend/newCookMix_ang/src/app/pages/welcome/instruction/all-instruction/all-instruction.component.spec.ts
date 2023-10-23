import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllInstructionComponent } from './all-instruction.component';

describe('AllInstructionComponent', () => {
  let component: AllInstructionComponent;
  let fixture: ComponentFixture<AllInstructionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AllInstructionComponent]
    });
    fixture = TestBed.createComponent(AllInstructionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
