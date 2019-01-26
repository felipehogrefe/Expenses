import { TestBed } from '@angular/core/testing';

import { MonthExpenseService } from './month-expense.service';

describe('MonthExpenseService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MonthExpenseService = TestBed.get(MonthExpenseService);
    expect(service).toBeTruthy();
  });
});
