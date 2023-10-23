import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddIngredientStepComponent } from './add-ingredient-step.component';

describe('AddIngredientStepComponent', () => {
  let component: AddIngredientStepComponent;
  let fixture: ComponentFixture<AddIngredientStepComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddIngredientStepComponent]
    });
    fixture = TestBed.createComponent(AddIngredientStepComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
