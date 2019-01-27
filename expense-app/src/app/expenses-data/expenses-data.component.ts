import { Component, OnInit } from '@angular/core';
import { Expense } from '../expense/expense';
import { ExpenseService } from '../expense/expense.service';

@Component({
  selector: 'app-expenses-data',
  templateUrl: './expenses-data.component.html',
  styleUrls: ['./expenses-data.component.css']
})
export class ExpensesDataComponent {

  expenses : Expense[];
  from : number = 1
  pace : number = 10

  edit = false;

  selectedExpense : Expense;

  constructor(private expenseService : ExpenseService) { }

  ngOnInit() {
    this.expenseService.getExpenses(this.from).subscribe(
      expenses => this.expenses = expenses);
  }
  
  editExpense(expense : Expense):void{
    this.edit = true;
    this.selectedExpense = expense;
    console.log('edit: '+expense.id)
  }

}
