import { Component, OnInit } from '@angular/core';
import { Expense } from '../expense/expense';
import { ExpenseService } from '../expense/expense.service';

@Component({
  selector: 'app-expenses-data',
  templateUrl: './expenses-data.component.html',
  styleUrls: ['./expenses-data.component.css']
})
export class ExpensesDataComponent {

  expenses: Expense[] = [];
  chunk: number = 0
  

  edit = false;
  deleted = false;
  edited = false;

  selectedExpense: Expense;

  constructor(private expenseService: ExpenseService) { }

  ngOnInit() {
    this.reloadData();
  }

  editExpense(expense: Expense): void {
    this.edit = true;
    this.selectedExpense = expense;
  }

  reloadData(): void {
    this.expenseService.getExpenses(this.chunk).subscribe(
      expenses => this.expenses = expenses);
  }

  previousData(): void {
    if(this.chunk>0){
      this.chunk--
      
      this.reloadData(); 
      if (this.expenses.length == 0) {
        this.chunk++
      }
      this.selectedExpense = null
      this.edit = false
      
    }
  }

  nextData(): void {    
    this.chunk++
    this.reloadData();
    if (this.expenses.length == 0) { 
      this.chunk--
    }
    this.selectedExpense = null
    this.edit = false
  }

  save(): void {
    this.expenseService.editExpense(this.selectedExpense).subscribe(response => {
      if (response === "OK") {
        this.edit = false;
        this.selectedExpense = null
        this.edited = true
        this.reloadData();
      } else {
        //show error component
      }
    }, error => {

    })
    this.selectedExpense = null
    this.edit = false
  }

  remove(): void {
    this.expenseService.deleteExpense(this.selectedExpense).subscribe(response => {
      console.log(response);
      if (response === "OK") {
        this.deleted = true;
        this.selectedExpense = null
        this.edit = false
        this.reloadData();
      } else {
        //show error component
      }
    }, error => {

    })

  }

}
