import { Component, OnInit } from '@angular/core';
import { Expense } from './Expense';
import { ExpenseService } from './expense.service';

@Component({
  selector: 'app-expense',
  templateUrl: './expense.component.html',
  styleUrls: ['./expense.component.css']
})
export class ExpenseComponent implements OnInit {

  expenses : Expense[];

  constructor(private expenseService : ExpenseService) { }

  ngOnInit() {
    this.expenseService.getExpenses(1).subscribe(
      expenses => this.expenses = expenses);
  }

}
