import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SourceExpenseComponent } from './source-expense.component';

describe('SourceExpenseComponent', () => {
  let component: SourceExpenseComponent;
  let fixture: ComponentFixture<SourceExpenseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SourceExpenseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SourceExpenseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
