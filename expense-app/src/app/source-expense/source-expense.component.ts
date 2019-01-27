import { Component, OnInit } from '@angular/core';
import { SourceExpense } from './SourceExpense';
import { SourceExpenseService } from './source-expense.service';

@Component({
  selector: 'app-source-expense',
  templateUrl: './source-expense.component.html',
  styleUrls: ['./source-expense.component.css']
})
export class SourceExpenseComponent{

  sourceExpenses : SourceExpense[];
  total : number = 0;

  constructor(private sourceExpenseService : SourceExpenseService){}

  ngOnInit(){
    this.sourceExpenseService.getSourceExpenses()
      .subscribe(sourceExpenses => {
        this.sourceExpenses = sourceExpenses
        for(let item of sourceExpenses){
          this.total += item.total
        }
      });
  }

}
