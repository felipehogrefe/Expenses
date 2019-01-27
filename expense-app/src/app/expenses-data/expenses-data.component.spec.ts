import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExpensesDataComponent } from './expenses-data.component';

describe('ExpensesDataComponent', () => {
  let component: ExpensesDataComponent;
  let fixture: ComponentFixture<ExpensesDataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExpensesDataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExpensesDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
