import { Component, OnInit } from '@angular/core';
import { MonthExpense } from './MonthExpense';
import { MonthExpenseService } from './month-expense.service';

@Component({
  selector: 'app-month-expense',
  templateUrl: './month-expense.component.html',
  styleUrls: ['./month-expense.component.css']
})
export class MonthExpenseComponent implements OnInit{

  monthExpenses : MonthExpense[];
  total : number = 0;

  constructor(private monthExpenseService : MonthExpenseService){}

  ngOnInit(){
    this.monthExpenseService.getMonthExpenses()
      .subscribe(monthExpenses => {
        this.monthExpenses = monthExpenses
        for(let item of monthExpenses){
          this.total += item.total
        }
      });
  }

}
