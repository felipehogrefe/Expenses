import { Component, OnInit } from '@angular/core';
import { Expense } from '../expense/expense';
import { ExpenseService } from '../expense/expense.service';

@Component({
  selector: 'app-expenses-data',
  templateUrl: './expenses-data.component.html',
  styleUrls: ['./expenses-data.component.css']
})
export class ExpensesDataComponent {

  expenses: Expense[];
  from: number = 1
  pace: number = 10

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

  previousData(): void {
    if (this.from > this.pace) {
      this.from -= this.pace;
      this.expenseService.getExpenses(this.from).subscribe(
        expenses => this.expenses = expenses);
        if(this.expenses.length==0){
          this.from += this.pace
        }
      this.selectedExpense = null
      this.edit = false
    }
  }

  reloadData():void{
    this.expenseService.getExpenses(this.from).subscribe(
      expenses => this.expenses = expenses);
  }

  nextData(): void {
    this.from += this.pace
    this.expenseService.getExpenses(this.from).subscribe(
      expenses => this.expenses = expenses);
      if(this.expenses.length==0){
        this.from -= this.pace
      }
    this.selectedExpense = null
    this.edit = false
  }

  save(): void {
    console.log(this.selectedExpense.ano_movimentacao)
    this.expenseService.editExpense(this.selectedExpense).subscribe(response => {
      if (response === "OK") {
        this.edit = false;
        this.selectedExpense = null
        this.edited = true        
      }else {
        //show error component
      }
    }, error => {        
      
    })

    console.log(this.selectedExpense.ano_movimentacao)
    this.selectedExpense = null
    this.edit = false
  }
  remove(): void {
    this.expenseService.deletExpense(this.selectedExpense).subscribe(response => {
      console.log(response);
      if (response === "OK") {
        this.deleted = true;
        this.selectedExpense = null
        this.edit = false
        this.reloadData();
      }else {
        //show error component
      }
    }, error => {        
      
    })
    
  }

}
