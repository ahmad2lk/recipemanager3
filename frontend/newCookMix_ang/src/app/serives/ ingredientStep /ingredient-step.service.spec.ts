import { TestBed } from '@angular/core/testing';

import { IngredientStepService } from './ingredient-step.service';

describe('IngredientStepService', () => {
  let service: IngredientStepService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IngredientStepService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
