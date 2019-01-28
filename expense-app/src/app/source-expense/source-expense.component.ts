import { Component, OnInit } from '@angular/core';
import { SourceExpense } from './SourceExpense';
import { SourceExpenseService } from './source-expense.service';
import { Expense } from '../expense/Expense';
import { ExpenseService } from '../expense/expense.service';

@Component({
  selector: 'app-source-expense',
  templateUrl: './source-expense.component.html',
  styleUrls: ['./source-expense.component.css']
})
export class SourceExpenseComponent{

  sourceExpenses : SourceExpense[];
  expenses : Expense[];
  availableCode : number[]
  total : number = 0;

  showByCode = false;

  constructor(private sourceExpenseService : SourceExpenseService, private expenseService : ExpenseService){}

  ngOnInit(){
    this.sourceExpenseService.getSourceExpenses()
      .subscribe(sourceExpenses => {
        this.sourceExpenses = sourceExpenses
        for(let item of sourceExpenses){
          this.total += item.total
        }
      });

      this.expenseService.getSourcesAvailableCodes()
      .subscribe(availableCode => {
        this.availableCode = availableCode
      });
  }

  showDataByCode(code:number):void{
    this.expenseService.getExpenseByCode("fonte_recurso_codigo",code)
      .subscribe(expenses => {
        this.expenses = expenses       
      });
    this.showByCode=true;
  }
}
