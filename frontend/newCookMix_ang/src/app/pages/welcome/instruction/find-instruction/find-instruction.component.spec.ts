import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindInstructionComponent } from './find-instruction.component';

describe('FindInstructionComponent', () => {
  let component: FindInstructionComponent;
  let fixture: ComponentFixture<FindInstructionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FindInstructionComponent]
    });
    fixture = TestBed.createComponent(FindInstructionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
