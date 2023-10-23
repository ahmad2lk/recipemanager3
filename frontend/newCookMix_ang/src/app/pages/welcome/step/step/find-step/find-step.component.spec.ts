import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindStepComponent } from './find-step.component';

describe('FindStepComponent', () => {
  let component: FindStepComponent;
  let fixture: ComponentFixture<FindStepComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FindStepComponent]
    });
    fixture = TestBed.createComponent(FindStepComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
