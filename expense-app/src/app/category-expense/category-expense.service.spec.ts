import { TestBed } from '@angular/core/testing';

import { CategoryExpenseService } from './category-expense.service';

describe('CategoryExpenseService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CategoryExpenseService = TestBed.get(CategoryExpenseService);
    expect(service).toBeTruthy();
  });
});
