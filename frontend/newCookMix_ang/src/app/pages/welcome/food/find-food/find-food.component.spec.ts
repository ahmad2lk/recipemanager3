import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindFoodComponent } from './find-food.component';

describe('FindFoodComponent', () => {
  let component: FindFoodComponent;
  let fixture: ComponentFixture<FindFoodComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FindFoodComponent]
    });
    fixture = TestBed.createComponent(FindFoodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
