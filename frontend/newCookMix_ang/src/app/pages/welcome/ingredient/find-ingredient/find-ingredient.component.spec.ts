import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindIngredientComponent } from './find-ingredient.component';

describe('FindIngredientComponent', () => {
  let component: FindIngredientComponent;
  let fixture: ComponentFixture<FindIngredientComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FindIngredientComponent]
    });
    fixture = TestBed.createComponent(FindIngredientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
