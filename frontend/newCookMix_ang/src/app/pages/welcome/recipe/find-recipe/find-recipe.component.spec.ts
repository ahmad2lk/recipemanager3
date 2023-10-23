import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindRecipeComponent } from './find-recipe.component';

describe('FindRecipeComponent', () => {
  let component: FindRecipeComponent;
  let fixture: ComponentFixture<FindRecipeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FindRecipeComponent]
    });
    fixture = TestBed.createComponent(FindRecipeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
