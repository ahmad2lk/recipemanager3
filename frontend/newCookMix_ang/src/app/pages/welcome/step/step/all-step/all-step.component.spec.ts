import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllStepComponent } from './all-step.component';

describe('AllStepComponent', () => {
  let component: AllStepComponent;
  let fixture: ComponentFixture<AllStepComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AllStepComponent]
    });
    fixture = TestBed.createComponent(AllStepComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
