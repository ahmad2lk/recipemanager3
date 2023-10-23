import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindIngredientStepComponent } from './find-ingredient-step.component';

describe('FindIngredientStepComponent', () => {
  let component: FindIngredientStepComponent;
  let fixture: ComponentFixture<FindIngredientStepComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FindIngredientStepComponent]
    });
    fixture = TestBed.createComponent(FindIngredientStepComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
