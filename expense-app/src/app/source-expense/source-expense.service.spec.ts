import { TestBed } from '@angular/core/testing';

import { SourceExpenseService } from './source-expense.service';

describe('SourceExpenseService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SourceExpenseService = TestBed.get(SourceExpenseService);
    expect(service).toBeTruthy();
  });
});
