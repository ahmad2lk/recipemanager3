import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllIngredientComponent } from './all-ingredient.component';

describe('AllIngredientComponent', () => {
  let component: AllIngredientComponent;
  let fixture: ComponentFixture<AllIngredientComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AllIngredientComponent]
    });
    fixture = TestBed.createComponent(AllIngredientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
