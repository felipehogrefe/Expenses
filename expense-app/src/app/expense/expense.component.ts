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

  startingChunk = 0

  constructor(private expenseService : ExpenseService) { }

  ngOnInit() {
    this.expenseService.getExpenses(this.startingChunk).subscribe(
      expenses => this.expenses = expenses);
  }

}
