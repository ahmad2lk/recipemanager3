import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IngredientStepComponent } from './ingredient-step.component';

describe('IngredientStepComponent', () => {
  let component: IngredientStepComponent;
  let fixture: ComponentFixture<IngredientStepComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [IngredientStepComponent]
    });
    fixture = TestBed.createComponent(IngredientStepComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
