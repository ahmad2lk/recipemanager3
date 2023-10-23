import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllIngredientStepComponent } from './all-ingredient-step.component';

describe('AllIngredientStepComponent', () => {
  let component: AllIngredientStepComponent;
  let fixture: ComponentFixture<AllIngredientStepComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AllIngredientStepComponent]
    });
    fixture = TestBed.createComponent(AllIngredientStepComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
